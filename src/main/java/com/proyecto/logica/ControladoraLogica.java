/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.logica;

import com.proyecto.persistencia.ControladoraPersistencia;
import com.proyecto.persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;

/**
 *
 * @author Matias
 */
public class ControladoraLogica {
    
    ControladoraPersistencia ctrl = new ControladoraPersistencia();
    
    //----- Carta -----
    
    public void crearCarta(Carta carta){
        ctrl.crearCarta(carta);
    }
    
    public Carta buscarCarta(int id){
        return ctrl.buscarCarta(id);
    }
    
    public void modificarCarta(Carta carta){
        ctrl.modificarCarta(carta);
    }
    
    public void borrarCarta(int id){
        ctrl.borrarCarta(id);
    }
    
    public ArrayList<Carta> listarCarta(){
        return ctrl.listarCarta();
    }
    

    //----- Pedido -----
    
    public void crearPedido(Pedido encomienda){
        ctrl.crearPedido(encomienda);
    }
    
    public Pedido buscarPedido(int idPedido){
        return ctrl.buscarPedido(idPedido);
    }
    
    public void modificarPedido(Pedido encomienda){
        ctrl.modificarPedido(encomienda);
    }
    
    public void eliminarPedido(int idPedido){
        ctrl.eliminarPedido(idPedido);
    }
    
    public ArrayList<Pedido> listaPedidos(){
        return ctrl.listaPedidos();

  
  //Usuario
    
    public void crearUsuario(usuario user) {
        ctrl.crearUsuario(user);
    }

    
    public void eliminarUsuario(int idUser) throws NonexistentEntityException {
        ctrl.borrarUsuario(idUser);
    }

    
    public usuario buscarUsuario(int idUser) {
        return ctrl.buscarUsuario(idUser);
    }

    
    public void modificarUsuario(usuario user) throws NonexistentEntityException{
        ctrl.modificarUsuario(user);
    }
    
    public ArrayList<usuario> listarUsuarios(){
        return ctrl.listarUsuarios();
    }
}

