/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.logica;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
    private usuario usuario;
    
    @OneToMany (mappedBy="reserva")
    private ArrayList<Mesa> mesas;
    

    
    public Reserva() {
    }

    public Reserva(int idReserva, Calendar fecha, Date hora, usuario usuario, ArrayList<Mesa> mesas) {
        this.idReserva = idReserva;
        this.fecha = fecha;
        this.hora = hora;
        this.usuario = usuario;
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
        return usuario;
    }

    public void setUsuario(usuario usuario) {
        this.usuario = usuario;
    }

    public ArrayList<Mesa> getMesas() {
        return mesas;
    }

    public void setMesas(ArrayList<Mesa> mesas) {
        this.mesas = mesas;
    }

    @Override
    public String toString() {
        return "Reserva{" + "idReserva=" + idReserva + ", fecha=" + fecha + ", hora=" + hora + ", usuario=" + usuario + ", mesas=" + mesas + '}';
    }    
}
