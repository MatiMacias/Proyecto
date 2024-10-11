package com.proyecto.servlet;

import com.proyecto.logica.ControladoraLogica;
import com.proyecto.logica.usuario;
import com.proyecto.persistencia.exceptions.NonexistentEntityException;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "svModificarUsuario", urlPatterns = {"/svModificarUsuario"})
public class svModificarUsuario extends HttpServlet {
    
    ControladoraLogica ctrl = new ControladoraLogica();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        int idMod = Integer.parseInt(request.getParameter("idUserMod"));
        
        usuario user = ctrl.buscarUsuario(idMod);
        
        HttpSession miSesion = request.getSession();
        miSesion.setAttribute("userMod", user);
        
        response.sendRedirect("modificarUsuario.jsp");
        
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
            
            String nombre = request.getParameter("nombre");
            String correo = request.getParameter("correo");
            String tipo = request.getParameter("tipo");
            
            usuario user = (usuario) request.getSession().getAttribute("UserMod");
            
            user.setNombre(nombre);
            user.setCorreo(correo);
            user.setTipo(tipo);
            
            ctrl.modificarUsuario(user);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(svModificarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
