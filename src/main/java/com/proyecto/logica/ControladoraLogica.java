/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.logica;

import com.proyecto.persistencia.ControladoraPersistencia;
import com.proyecto.persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Matias
 */
public class ControladoraLogica {
 
    ControladoraPersistencia ctrl = new ControladoraPersistencia();
    //----- Login -----
    
    public boolean validarIngreso(String usuario, String contrasena){
        boolean ingreso = false;
        
        List<usuario> listaUser = new ArrayList<usuario>();
        listaUser = ctrl.listarUsuarios();
        
        for(usuario user : listaUser){
            if(user.getNombre().equals(usuario)){
                if(user.getContrasena().equals(contrasena)){
                           ingreso = true;
                }
            }else{ingreso = false;}
        }
        return ingreso;
    }
    
    //----- Carta -----
    
    public void crearCarta(Carta carta){
        ctrl.crearCarta(carta);
    }
    
    public Carta buscarCarta(int idCarta){
        return ctrl.buscarCarta(idCarta);
    }
    
    public Carta buscarCartaNombre(String nombre){
        return ctrl.buscarCartaNombre(nombre);
    }
    
    public void modificarCarta(Carta carta){
        ctrl.modificarCarta(carta);
    }
    
    public void borrarCarta(int idCarta){
        ctrl.borrarCarta(idCarta);
    }
    
    public ArrayList<Carta> listarCartas(){
        return ctrl.consultarCarta();
    }
    
    //----- Categoria ------
    
    public void crearCategoria(Categoria categoria){
        ctrl.crearCategoria(categoria);
    }
    
    public Categoria buscarCategoria(int idCategoria){
        return ctrl.buscarCategoria(idCategoria);
    }
    
    public Categoria buscarCategoriaNombre(String nombre){
        return ctrl.buscarCategoriaNombre(nombre);
    }
    
    public void modificarCategoria(Categoria categoria){
        ctrl.modificarCategoria(categoria);
    }
    
    public void borrarCategoria(int idCategoria){
        ctrl.borrarCategoria(idCategoria);
    }
    
    public ArrayList<Categoria> listarCategoria(){
        return ctrl.consultarCategoria();
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
    }

  
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
    
    //-----------------MESAS------------------
    public void crearMesa(Mesa mesita){
        ctrl.crearMesa(mesita);
    }
    
    public Mesa buscarMesa(int numMesa){
        return ctrl.buscarMesa(numMesa);
    }
    
    public void modificarMesa(Mesa mesita){
        ctrl.modificarMesa(mesita);
    }
    
    public void borrarMesa(int numMesa){
        ctrl.borrarMesa(numMesa);
    }
    
    public ArrayList<Mesa> listarMesas(){
        return ctrl.listarMesas();
    }
    
    public List<Mesa> traerMesas(){
        return ctrl.traerMesas();
    }
    
    //----------------RESERVAS----------------
    public void crearReserva(Reserva reser){
        ctrl.crearReserva(reser);
    }
    
    public Reserva buscarReserva(int idReserva){
        return ctrl.buscarReserva(idReserva);
    }
    
    public void modificarReserva(Reserva reser){
        ctrl.modificarReserva(reser);
    }
    
    public void borrarReserva(int idReserva){
        ctrl.borrarReserva(idReserva);
    }
    
    public ArrayList<Reserva> listarReservas(){
        return ctrl.listarReservas();
    }
    
    public List<Reserva> traerReservas(){
        return ctrl.traerReservas();
    }
}

