/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.servlet;

import com.proyecto.logica.ControladoraLogica;
import com.proyecto.logica.Pedido;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Brython
 */
@WebServlet(name = "svPedido", urlPatterns = {"/svPedido"})
public class svPedido extends HttpServlet {

    ControladoraLogica ctrlLogica = new ControladoraLogica();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        List<Pedido> listarPedidos = new ArrayList<>();
        
        listarPedidos = ctrlLogica.listaPedidos();
        
        HttpSession misesion = (HttpSession) request.getSession();
        misesion.setAttribute("listaPedidos", listarPedidos);
        response.sendRedirect("mostrarPedidos.jsp");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        double precio = Double.parseDouble(request.getParameter("precio"));
        String hora = request.getParameter("horario");
        
        Pedido enco = new Pedido();
        
        enco.setTotalPedido(precio);
        enco.setHoraPedido(Date.from(Instant.parse(hora)));
        
        ctrlLogica.crearPedido(enco);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
