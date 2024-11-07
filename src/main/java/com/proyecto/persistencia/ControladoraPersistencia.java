package com.proyecto.persistencia;

import com.proyecto.logica.usuario;
import com.proyecto.logica.Carta;
import com.proyecto.logica.Mesa;
import com.proyecto.logica.Pedido;
import com.proyecto.logica.Reserva;
import com.proyecto.persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matias
 */
public class ControladoraPersistencia {
 
     

    CartaJpaController car = new CartaJpaController();
    
    // Controladora para la entidad Carta


    public void crearCarta(Carta carta) {
        car.create(carta);
    }

    public Carta buscarCarta(int id) {
        return car.findCarta(id);
    }

    public void modificarCarta(Carta carta) {
         try {
             car.edit(carta);
         } catch (Exception ex) {
             Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    public void borrarCarta(int id) {
         try {
             car.destroy(id);
         } catch (NonexistentEntityException ex) {
             Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    public ArrayList<Carta> listarCarta() {
        List<Carta> listac = car.findCartaEntities();
        ArrayList<Carta> lista = new ArrayList<>(listac);
        return lista;
    }

    //----- Pedidos -----
  
    PedidoJpaController enco = new PedidoJpaController();
    
    public void crearPedido(Pedido encomienda) {
        enco.create(encomienda);
    }

    public Pedido buscarPedido(int idPedido) {
        return enco.findPedido(idPedido);
    }

    public void modificarPedido(Pedido encomienda) {
         try {
             enco.edit(encomienda);
         } catch (Exception ex) {
             Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    public void eliminarPedido(int idPedido) {
         try {
             enco.destroy(idPedido);
         } catch (NonexistentEntityException ex) {
             Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    public ArrayList<Pedido> listaPedidos() {
        List<Pedido> listaP = enco.findPedidoEntities();
        ArrayList<Pedido> listaPedidos = new ArrayList<Pedido> (listaP);
        return listaPedidos;
    }
    
    // Controladora para la entidad Usuario
    usuarioJpaController user = new usuarioJpaController();

    public void crearUsuario(usuario user) {
        this.user.create(user);
    }

    public usuario buscarUsuario(int idUser) {
        return this.user.findusuario(idUser);
    }

    public void borrarUsuario(int idUser) throws NonexistentEntityException {
        try {
            this.user.destroy(idUser);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
            throw ex; // Lanza la excepción para manejarla en la capa superior
        }
    }

    public void modificarUsuario(usuario user) throws NonexistentEntityException {
        try {
            this.user.edit(user);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
            throw ex; // Lanza la excepción para manejarla en la capa superior
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
            // Manejo de otras excepciones si es necesario
        }
    }
    
    public ArrayList<usuario> listarUsuarios() {
        List<usuario> listau = user.findusuarioEntities();
        ArrayList<usuario> lista = new ArrayList<>(listau);
        return lista;
    }
    
    //-------------------MESAS--------------------------
    MesaJpaController mesaJpa = new MesaJpaController();
    
    public void crearMesa(Mesa mesita) {
         try {
             mesaJpa.create(mesita);
         } catch (Exception ex) {
             Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    public Mesa buscarMesa(int numMesa) {
        return mesaJpa.findMesa(numMesa);
    }

    public void modificarMesa(Mesa mesita) {
         try {
             mesaJpa.edit(mesita);
         } catch (Exception ex) {
             Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    public void borrarMesa(int numMesa) {
         try {
             mesaJpa.destroy(numMesa);
         } catch (NonexistentEntityException ex) {
             Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    public ArrayList<Mesa> listarMesas() {
        List<Mesa> listMesa = mesaJpa.findMesaEntities();
        ArrayList<Mesa> arrayMesa = new ArrayList<>(listMesa);
        return arrayMesa;
    }

    public List<Mesa> traerMesas() {
        return mesaJpa.findMesaEntities();
    }
    
    //------------------RESERVAS--------------------------
    
    ReservaJpaController resJpa = new ReservaJpaController();

    public void crearReserva(Reserva reser) {
        resJpa.create(reser);
    }

    public Reserva buscarReserva(int idReserva) {
        return resJpa.findReserva(idReserva);
    }

    public void modificarReserva(Reserva reser) {
         try {
             resJpa.edit(reser);
         } catch (Exception ex) {
             Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    public void borrarReserva(int idReserva) {
         try {
             resJpa.destroy(idReserva);
         } catch (NonexistentEntityException ex) {
             Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    public ArrayList<Reserva> listarReservas() {
        List<Reserva> listReserva = resJpa.findReservaEntities();
        ArrayList<Reserva> arrayReserva = new ArrayList<>(listReserva);
        return arrayReserva;
    }

    public List<Reserva> traerReservas() {
        return resJpa.findReservaEntities();
    }
    
}
