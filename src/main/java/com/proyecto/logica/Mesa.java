/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.logica;

import java.io.Serializable;
import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

/**
 *
 * @author franc
 */
@Entity
public class Mesa implements Serializable {
    @Id
    private int numMesa;
    @Basic
    private String estado;
    @ManyToOne
    private Reserva reserva;
    
    @OneToOne
    private Pedido pedido;
    
    
    
    public Mesa() {
    }

    public Mesa(int numMesa, String estado, Reserva reserva, Pedido pedido) {
        this.numMesa = numMesa;
        this.estado = estado;
        this.reserva = reserva;
        this.pedido = pedido;
    }

    
    
    public int getNumMesa() {
        return numMesa;
    }

    public void setNumMesa(int numMesa) {
        this.numMesa = numMesa;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public String toString() {
        return "Mesa{" + "numMesa=" + numMesa + ", estado=" + estado + ", reserva=" + reserva + ", pedido=" + pedido + '}';
    }
    
    

    
}
