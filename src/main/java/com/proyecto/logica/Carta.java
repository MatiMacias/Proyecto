package com.proyecto.logica;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Carta implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idProducto;
    
    private String nombreProducto;
 
    private Double precioProducto;
    
    @ManyToOne
    private Categoria categoriaProd;
    
    
    
    

    public Carta() {
    }

    public Carta(int idProducto, String nombreProducto, Double precioProducto, Categoria categoriaProd) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;
        this.categoriaProd = categoriaProd;
    }

    

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public Categoria getCategoria() {
        return categoriaProd;
    }

    public void setCategoria(Categoria categoriaProd) {
        this.categoriaProd = categoriaProd;
    }

    

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(Double precioProducto) {
        this.precioProducto = precioProducto;
    }

    

    @Override
    public String toString() {
        return "Carta{" + "idProducto=" + idProducto + ", nombreProducto=" + nombreProducto + ", precioProducto=" + precioProducto + ", categoria=" + categoriaProd + '}';
    }

    
}
