/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.persistencia;

import com.proyecto.logica.Carta;
import com.proyecto.logica.Pedido;
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
     PedidoJpaController enco = new PedidoJpaController();

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
        ArrayList<Carta> lista = new ArrayList<Carta>(listac);
        return lista;
    }

    //----- Pedidos -----
    
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
    
}
