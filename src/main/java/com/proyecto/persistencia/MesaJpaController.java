/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.persistencia;

import com.proyecto.logica.Mesa;
import java.io.Serializable;
import jakarta.persistence.Query;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import com.proyecto.logica.Reserva;
import com.proyecto.persistencia.exceptions.NonexistentEntityException;
import com.proyecto.persistencia.exceptions.PreexistingEntityException;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 *
 * @author Matias
 */
public class MesaJpaController implements Serializable {

    public MesaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    public MesaJpaController(){
        emf=Persistence.createEntityManagerFactory("proyectoPU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Mesa mesa) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Reserva reserva = mesa.getReserva();
            if (reserva != null) {
                reserva = em.getReference(reserva.getClass(), reserva.getIdReserva());
                mesa.setReserva(reserva);
            }
            em.persist(mesa);
            if (reserva != null) {
                reserva.getMesas().add(mesa);
                reserva = em.merge(reserva);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMesa(mesa.getNumMesa()) != null) {
                throw new PreexistingEntityException("Mesa " + mesa + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Mesa mesa) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Mesa persistentMesa = em.find(Mesa.class, mesa.getNumMesa());
            Reserva reservaOld = persistentMesa.getReserva();
            Reserva reservaNew = mesa.getReserva();
            if (reservaNew != null) {
                reservaNew = em.getReference(reservaNew.getClass(), reservaNew.getIdReserva());
                mesa.setReserva(reservaNew);
            }
            mesa = em.merge(mesa);
            if (reservaOld != null && !reservaOld.equals(reservaNew)) {
                reservaOld.getMesas().remove(mesa);
                reservaOld = em.merge(reservaOld);
            }
            if (reservaNew != null && !reservaNew.equals(reservaOld)) {
                reservaNew.getMesas().add(mesa);
                reservaNew = em.merge(reservaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = mesa.getNumMesa();
                if (findMesa(id) == null) {
                    throw new NonexistentEntityException("The mesa with id " + id + " no longer exists.");
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
            Mesa mesa;
            try {
                mesa = em.getReference(Mesa.class, id);
                mesa.getNumMesa();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The mesa with id " + id + " no longer exists.", enfe);
            }
            Reserva reserva = mesa.getReserva();
            if (reserva != null) {
                reserva.getMesas().remove(mesa);
                reserva = em.merge(reserva);
            }
            em.remove(mesa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Mesa> findMesaEntities() {
        return findMesaEntities(true, -1, -1);
    }

    public List<Mesa> findMesaEntities(int maxResults, int firstResult) {
        return findMesaEntities(false, maxResults, firstResult);
    }

    private List<Mesa> findMesaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Mesa.class));
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

    public Mesa findMesa(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Mesa.class, id);
        } finally {
            em.close();
        }
    }

    public int getMesaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Mesa> rt = cq.from(Mesa.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
