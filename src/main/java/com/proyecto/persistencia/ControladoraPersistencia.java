package com.proyecto.persistencia;

import com.proyecto.logica.usuario;
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
    
    // Controladora para la entidad Carta
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
        ArrayList<Carta> lista = new ArrayList<>(listac);
        return lista;
    }
    
    // Controladora para la entidad Usuario
    usuarioJpaController user = new usuarioJpaController();

    public void crearUsuario(usuario user) {
        this.user.create(user);
    }

    public usuario buscarUsuario(int idUser) {
        return this.user.findusuario(idUser);
    }

    public void borrarUsuario(int idUser) throws NonexistentEntityException {
        try {
            this.user.destroy(idUser);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
            throw ex; // Lanza la excepción para manejarla en la capa superior
        }
    }

    public void modificarUsuario(usuario user) throws NonexistentEntityException {
        try {
            this.user.edit(user);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
            throw ex; // Lanza la excepción para manejarla en la capa superior
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
            // Manejo de otras excepciones si es necesario
        }
    }
    
    public ArrayList<usuario> listarUsuarios() {
        List<usuario> listau = user.findusuarioEntities();
        ArrayList<usuario> lista = new ArrayList<>(listau);
        return lista;
    }
}
