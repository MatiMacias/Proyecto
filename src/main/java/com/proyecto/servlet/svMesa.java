/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.proyecto.servlet;

import com.proyecto.logica.ControladoraLogica;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.proyecto.logica.Mesa;


/**
 *
 * @author franc
 */
@WebServlet(name = "svMesa", urlPatterns = {"/svMesa"})
public class svMesa extends HttpServlet {
    ControladoraLogica logica = new ControladoraLogica();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Mesa> listaMesas = new ArrayList<>();
        listaMesas = logica.traerMesas();
        
        HttpSession misesion = request.getSession();
        misesion.setAttribute("listaMesas", listaMesas);
        
        response.sendRedirect("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nMesa = request.getParameter("numMesa");
        String estado = request.getParameter("estado");
        //String reserva = request.getParameter("reserva");
        
        Mesa mesa = new Mesa();
        mesa.setNumMesa(Integer.parseInt(nMesa));
        mesa.setEstado(estado);
        //mesa.setReserva());
        
        logica.crearMesa(mesa);
        response.sendRedirect("MesaCarga.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
