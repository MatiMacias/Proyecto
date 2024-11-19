/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.logica;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.OneToMany;

/**
 *
 * @author Brython
 */
@Entity
public class Pedido implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idPedido;
    private double totalPedido;
    @Temporal(TemporalType.TIME)
    private Date horaPedido;
    
    @OneToMany
    @JoinColumn(name = "pedido_id")
    private ArrayList<Carta> listaProductos;
    
    

    public Pedido() {
    }

    public Pedido(int idPedido, double totalPedido, Date horaPedido, ArrayList<Carta> listaProductos) {
        this.idPedido = idPedido;
        this.totalPedido = totalPedido;
        this.horaPedido = horaPedido;
        this.listaProductos = listaProductos;
    }

    

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Date getHoraPedido() {
        return horaPedido;
    }

    public void setHoraPedido(Date horaPedido) {
        this.horaPedido = horaPedido;
    }

    public double getTotalPedido() {
        return totalPedido;
    }

    public void setTotalPedido(double totalPedido) {
        this.totalPedido = totalPedido;
    }

    public ArrayList<Carta> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Carta> listaProductos) {
        this.listaProductos = listaProductos;
    }

    @Override
    public String toString() {
        return "Pedido{" + "idPedido=" + idPedido + ", totalPedido=" + totalPedido + ", horaPedido=" + horaPedido + ", listaProductos=" + listaProductos + '}';
    }
    
    

    
    
}
