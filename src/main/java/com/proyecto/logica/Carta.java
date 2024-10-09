package com.proyecto.logica;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Carta implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idProducto;
    
    private String Categoria;
    
    private String nombreProducto;
 
    private Double precioProducto;

    public Carta(){}

    public Carta(int idProducto, String Categoria, String nombreProducto, Double precioProducto) {
        this.idProducto = idProducto;
        this.Categoria = Categoria;
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;
    }
     
    
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
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
        return "Carta{" + "idProducto=" + idProducto + ", nombreProducto=" + nombreProducto + ", precioProducto=" + precioProducto + '}';
    }
    
    
}
