/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.proyecto.servlet;

import com.proyecto.logica.Carta;
import com.proyecto.logica.ControladoraLogica;
import com.proyecto.logica.Reserva;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.proyecto.logica.usuario;
import java.util.ArrayList;



@WebServlet(name = "svRegister", urlPatterns = {"/svRegister"})
public class svRegister extends HttpServlet {
    
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
        processRequest(request, response);
        
        String usuario = request.getParameter("usuario");
        String contrasena = request.getParameter("contrasena");
        String email = request.getParameter("email");
        
        
        usuario user = new usuario();
        
        user.setNombre(usuario);
        user.setContrasena(contrasena);
        user.setCorreo(email);
        
        
        ctrl.crearUsuario(user);
        response.sendRedirect("index.jsp");
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
