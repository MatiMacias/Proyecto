package com.proyecto.logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Carta implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idProducto;
    
    private String Categoria;
    
    private String nombreProducto;
 
    private Double precioProducto;
    
    @ManyToOne
    private Pedido pedido;
    
    @ManyToOne
    private usuario usuario;


    public Carta(){}

    public Carta(int idProducto, String Categoria, String nombreProducto, Double precioProducto, Pedido pedido, usuario usuario) {
        this.idProducto = idProducto;
        this.Categoria = Categoria;
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;
        this.pedido = pedido;
        this.usuario = usuario;
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

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Carta{" + "idProducto=" + idProducto + ", Categoria=" + Categoria + ", nombreProducto=" + nombreProducto + ", precioProducto=" + precioProducto + ", pedido=" + pedido + ", usuario=" + usuario + '}';
    }
    
    

    
    

    
}
