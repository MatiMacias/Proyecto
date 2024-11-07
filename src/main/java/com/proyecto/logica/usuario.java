/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.logica;


import jakarta.persistence.OneToMany;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author santi
 */
@Entity
public class usuario implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; 
    
    private String nombre;
    private String correo;
    private String contrasena;
    private String tipo;
    
    @OneToMany (mappedBy = "usuarioRes")
    private ArrayList<Reserva> reservas;
    
    @OneToMany (mappedBy = "usuarioProd")
    private ArrayList<Carta> carta;

    public usuario() {
    }

    public usuario(int id, String nombre, String correo, String contrasena, String tipo, ArrayList<Reserva> reservas, ArrayList<Carta> carta) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
        this.tipo = tipo;
        this.reservas = reservas;
        this.carta = carta;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }

    public ArrayList<Carta> getCarta() {
        return carta;
    }

    public void setCarta(ArrayList<Carta> carta) {
        this.carta = carta;
    }

    @Override
    public String toString() {
        return "usuario{" + "id=" + id + ", nombre=" + nombre + ", correo=" + correo + ", contrasena=" + contrasena + ", tipo=" + tipo + ", reservas=" + reservas + ", carta=" + carta + '}';
    }

    
}
