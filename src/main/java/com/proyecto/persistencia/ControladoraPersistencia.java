/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.persistencia;

import com.proyecto.logica.Carta;
import com.proyecto.persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Matias
 */
public class ControladoraPersistencia {
    
     CartaJpaController car = new CartaJpaController();

    public void crearCarta(Carta carta) {
        car.create(carta);
    }

    public Carta buscarCarta(int id) {
        return car.findCarta(id);
    }

    public void modificarCarta(Carta carta) {
         try {
             car.edit(carta);
         } catch (Exception ex) {
             Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    public void borrarCarta(int id) {
         try {
             car.destroy(id);
         } catch (NonexistentEntityException ex) {
             Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    public ArrayList<Carta> listarCarta() {
        List<Carta> listac = car.findCartaEntities();
        ArrayList<Carta> lista = new ArrayList<Carta>(listac);
        return lista;
    }
    
}
