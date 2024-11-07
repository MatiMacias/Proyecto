/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.logica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

/**
 *
 * @author franc
 */
@Entity
public class Reserva implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int idReserva;
    @Temporal(TemporalType.DATE)
    private Calendar fecha;
    @Temporal(TemporalType.TIME)
    private Date hora;
    
    @ManyToOne
    private usuario usuarioRes;
    
    @OneToMany (mappedBy="reserva")
    private ArrayList<Mesa> mesas;
    

    
    public Reserva() {
    }

    public Reserva(int idReserva, Calendar fecha, Date hora, usuario usuario, ArrayList<Mesa> mesas) {
        this.idReserva = idReserva;
        this.fecha = fecha;
        this.hora = hora;
        this.usuarioRes = usuario;
        this.mesas = mesas;
    }

    

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public usuario getUsuario() {
        return usuarioRes;
    }

    public void setUsuario(usuario usuarioRes) {
        this.usuarioRes = usuarioRes;
    }

    public ArrayList<Mesa> getMesas() {
        return mesas;
    }

    public void setMesas(ArrayList<Mesa> mesas) {
        this.mesas = mesas;
    }

    @Override
    public String toString() {
        return "Reserva{" + "idReserva=" + idReserva + ", fecha=" + fecha + ", hora=" + hora + ", usuario=" + usuarioRes + ", mesas=" + mesas + '}';
    }    
}
