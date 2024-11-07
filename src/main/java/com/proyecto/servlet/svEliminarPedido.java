/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.servlet;

import com.proyecto.logica.ControladoraLogica;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Brython
 */
@WebServlet(name = "svEliminarPedido", urlPatterns = {"/svEliminarPedido"})
public class svEliminarPedido extends HttpServlet {

    ControladoraLogica ctrlLogica = new ControladoraLogica();
    
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
        
        int idEliminar = Integer.parseInt(request.getParameter("idPedidos"));
        
        ctrlLogica.eliminarPedido(idEliminar);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
