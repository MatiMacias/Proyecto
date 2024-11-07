/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.persistencia;

import java.io.Serializable;
import jakarta.persistence.Query;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import com.proyecto.logica.Carta;
import com.proyecto.logica.Pedido;
import com.proyecto.persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 *
 * @author Matias
 */
public class PedidoJpaController implements Serializable {

    public PedidoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public PedidoJpaController(){
        emf=Persistence.createEntityManagerFactory("proyectoPU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Pedido pedido) {
        if (pedido.getListaProductos() == null) {
            pedido.setListaProductos(new ArrayList<Carta>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ArrayList<Carta> attachedListaProductos = new ArrayList<Carta>();
            for (Carta listaProductosCartaToAttach : pedido.getListaProductos()) {
                listaProductosCartaToAttach = em.getReference(listaProductosCartaToAttach.getClass(), listaProductosCartaToAttach.getIdProducto());
                attachedListaProductos.add(listaProductosCartaToAttach);
            }
            pedido.setListaProductos(attachedListaProductos);
            em.persist(pedido);
            for (Carta listaProductosCarta : pedido.getListaProductos()) {
                Pedido oldPedidoOfListaProductosCarta = listaProductosCarta.getPedido();
                listaProductosCarta.setPedido(pedido);
                listaProductosCarta = em.merge(listaProductosCarta);
                if (oldPedidoOfListaProductosCarta != null) {
                    oldPedidoOfListaProductosCarta.getListaProductos().remove(listaProductosCarta);
                    oldPedidoOfListaProductosCarta = em.merge(oldPedidoOfListaProductosCarta);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Pedido pedido) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pedido persistentPedido = em.find(Pedido.class, pedido.getIdPedido());
            ArrayList<Carta> listaProductosOld = persistentPedido.getListaProductos();
            ArrayList<Carta> listaProductosNew = pedido.getListaProductos();
            ArrayList<Carta> attachedListaProductosNew = new ArrayList<Carta>();
            for (Carta listaProductosNewCartaToAttach : listaProductosNew) {
                listaProductosNewCartaToAttach = em.getReference(listaProductosNewCartaToAttach.getClass(), listaProductosNewCartaToAttach.getIdProducto());
                attachedListaProductosNew.add(listaProductosNewCartaToAttach);
            }
            listaProductosNew = attachedListaProductosNew;
            pedido.setListaProductos(listaProductosNew);
            pedido = em.merge(pedido);
            for (Carta listaProductosOldCarta : listaProductosOld) {
                if (!listaProductosNew.contains(listaProductosOldCarta)) {
                    listaProductosOldCarta.setPedido(null);
                    listaProductosOldCarta = em.merge(listaProductosOldCarta);
                }
            }
            for (Carta listaProductosNewCarta : listaProductosNew) {
                if (!listaProductosOld.contains(listaProductosNewCarta)) {
                    Pedido oldPedidoOfListaProductosNewCarta = listaProductosNewCarta.getPedido();
                    listaProductosNewCarta.setPedido(pedido);
                    listaProductosNewCarta = em.merge(listaProductosNewCarta);
                    if (oldPedidoOfListaProductosNewCarta != null && !oldPedidoOfListaProductosNewCarta.equals(pedido)) {
                        oldPedidoOfListaProductosNewCarta.getListaProductos().remove(listaProductosNewCarta);
                        oldPedidoOfListaProductosNewCarta = em.merge(oldPedidoOfListaProductosNewCarta);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = pedido.getIdPedido();
                if (findPedido(id) == null) {
                    throw new NonexistentEntityException("The pedido with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pedido pedido;
            try {
                pedido = em.getReference(Pedido.class, id);
                pedido.getIdPedido();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pedido with id " + id + " no longer exists.", enfe);
            }
            ArrayList<Carta> listaProductos = pedido.getListaProductos();
            for (Carta listaProductosCarta : listaProductos) {
                listaProductosCarta.setPedido(null);
                listaProductosCarta = em.merge(listaProductosCarta);
            }
            em.remove(pedido);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Pedido> findPedidoEntities() {
        return findPedidoEntities(true, -1, -1);
    }

    public List<Pedido> findPedidoEntities(int maxResults, int firstResult) {
        return findPedidoEntities(false, maxResults, firstResult);
    }

    private List<Pedido> findPedidoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Pedido.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Pedido findPedido(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Pedido.class, id);
        } finally {
            em.close();
        }
    }

    public int getPedidoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Pedido> rt = cq.from(Pedido.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
