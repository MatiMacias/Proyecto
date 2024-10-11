/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.logica;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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

    
    public Mesa() {
    }

    public Mesa(int numMesa, String estado, Reserva reserva) {
        this.numMesa = numMesa;
        this.estado = estado;
        this.reserva = reserva;
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

    @Override
    public String toString() {
        return "Mesa{" + "numMesa=" + numMesa + ", estado=" + estado + ", reserva=" + reserva + '}';
    }
}
