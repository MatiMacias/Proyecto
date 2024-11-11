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
import com.proyecto.logica.usuario;
import com.proyecto.logica.Mesa;
import com.proyecto.logica.Reserva;
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
public class ReservaJpaController implements Serializable {

    public ReservaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public ReservaJpaController(){
        emf=Persistence.createEntityManagerFactory("proyectoPU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Reserva reserva) {
        if (reserva.getMesas() == null) {
            reserva.setMesas(new ArrayList<Mesa>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            usuario usuario = reserva.getUsuarioRes();
            if (usuario != null) {
                usuario = em.getReference(usuario.getClass(), usuario.getId());
                reserva.setUsuarioRes(usuario);
            }
            ArrayList<Mesa> attachedMesas = new ArrayList<Mesa>();
            for (Mesa mesasMesaToAttach : reserva.getMesas()) {
                mesasMesaToAttach = em.getReference(mesasMesaToAttach.getClass(), mesasMesaToAttach.getNumMesa());
                attachedMesas.add(mesasMesaToAttach);
            }
            reserva.setMesas(attachedMesas);
            em.persist(reserva);
            if (usuario != null) {
                usuario.getReservas().add(reserva);
                usuario = em.merge(usuario);
            }
            for (Mesa mesasMesa : reserva.getMesas()) {
                Reserva oldReservaOfMesasMesa = mesasMesa.getReserva();
                mesasMesa.setReserva(reserva);
                mesasMesa = em.merge(mesasMesa);
                if (oldReservaOfMesasMesa != null) {
                    oldReservaOfMesasMesa.getMesas().remove(mesasMesa);
                    oldReservaOfMesasMesa = em.merge(oldReservaOfMesasMesa);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Reserva reserva) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Reserva persistentReserva = em.find(Reserva.class, reserva.getIdReserva());
            usuario usuarioOld = persistentReserva.getUsuarioRes();
            usuario usuarioNew = reserva.getUsuarioRes();
            List<Mesa> mesasOld = persistentReserva.getMesas();
            List<Mesa> mesasNew = reserva.getMesas();
            if (usuarioNew != null) {
                usuarioNew = em.getReference(usuarioNew.getClass(), usuarioNew.getId());
                reserva.setUsuarioRes(usuarioNew);
            }
            ArrayList<Mesa> attachedMesasNew = new ArrayList<Mesa>();
            for (Mesa mesasNewMesaToAttach : mesasNew) {
                mesasNewMesaToAttach = em.getReference(mesasNewMesaToAttach.getClass(), mesasNewMesaToAttach.getNumMesa());
                attachedMesasNew.add(mesasNewMesaToAttach);
            }
            mesasNew = attachedMesasNew;
            reserva.setMesas(mesasNew);
            reserva = em.merge(reserva);
            if (usuarioOld != null && !usuarioOld.equals(usuarioNew)) {
                usuarioOld.getReservas().remove(reserva);
                usuarioOld = em.merge(usuarioOld);
            }
            if (usuarioNew != null && !usuarioNew.equals(usuarioOld)) {
                usuarioNew.getReservas().add(reserva);
                usuarioNew = em.merge(usuarioNew);
            }
            for (Mesa mesasOldMesa : mesasOld) {
                if (!mesasNew.contains(mesasOldMesa)) {
                    mesasOldMesa.setReserva(null);
                    mesasOldMesa = em.merge(mesasOldMesa);
                }
            }
            for (Mesa mesasNewMesa : mesasNew) {
                if (!mesasOld.contains(mesasNewMesa)) {
                    Reserva oldReservaOfMesasNewMesa = mesasNewMesa.getReserva();
                    mesasNewMesa.setReserva(reserva);
                    mesasNewMesa = em.merge(mesasNewMesa);
                    if (oldReservaOfMesasNewMesa != null && !oldReservaOfMesasNewMesa.equals(reserva)) {
                        oldReservaOfMesasNewMesa.getMesas().remove(mesasNewMesa);
                        oldReservaOfMesasNewMesa = em.merge(oldReservaOfMesasNewMesa);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = reserva.getIdReserva();
                if (findReserva(id) == null) {
                    throw new NonexistentEntityException("The reserva with id " + id + " no longer exists.");
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
            Reserva reserva;
            try {
                reserva = em.getReference(Reserva.class, id);
                reserva.getIdReserva();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The reserva with id " + id + " no longer exists.", enfe);
            }
            usuario usuario = reserva.getUsuarioRes();
            if (usuario != null) {
                usuario.getReservas().remove(reserva);
                usuario = em.merge(usuario);
            }
            List<Mesa> mesas = reserva.getMesas();
            for (Mesa mesasMesa : mesas) {
                mesasMesa.setReserva(null);
                mesasMesa = em.merge(mesasMesa);
            }
            em.remove(reserva);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Reserva> findReservaEntities() {
        return findReservaEntities(true, -1, -1);
    }

    public List<Reserva> findReservaEntities(int maxResults, int firstResult) {
        return findReservaEntities(false, maxResults, firstResult);
    }

    private List<Reserva> findReservaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Reserva.class));
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

    public Reserva findReserva(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Reserva.class, id);
        } finally {
            em.close();
        }
    }

    public int getReservaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Reserva> rt = cq.from(Reserva.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
