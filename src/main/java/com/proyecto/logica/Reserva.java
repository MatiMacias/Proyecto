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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.List;

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
    private String nombre;
    private String apellido;
    private String telefono;
    
    
    @OneToOne
    private Mesa mesas;
    

    
    public Reserva() {
    }

    public Reserva(int idReserva, Calendar fecha, Date hora, String nombre, String apellido, String telefono, List<Mesa> mesas) {
        this.idReserva = idReserva;
        this.fecha = fecha;
        this.hora = hora;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Mesa getMesas() {
        return mesas;
    }

    public void setMesas(Mesa mesas) {
        this.mesas = mesas;
    }
    
    

    @Override
    public String toString() {
        return "Reserva{" + "idReserva=" + idReserva + ", fecha=" + fecha + ", hora=" + hora + ", nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono + ", usuarioRes=" + '}';
    }

  
}
