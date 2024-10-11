package com.proyecto.servlet;

import com.proyecto.logica.ControladoraLogica;
import com.proyecto.persistencia.exceptions.NonexistentEntityException;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "svEliminarUsuario", urlPatterns = {"/svEliminarUsuario"})
public class svEliminarUsuario extends HttpServlet {
    
    ControladoraLogica ctrl = new ControladoraLogica();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
            
            int idBorrar = Integer.parseInt(request.getParameter("id"));
            
            ctrl.eliminarUsuario(idBorrar);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(svEliminarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
