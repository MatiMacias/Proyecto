/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.proyecto.servlet;

import com.proyecto.logica.Carta;
import com.proyecto.logica.ControladoraLogica;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Matias
 */
@WebServlet(name = "svCarta", urlPatterns = {"/svCarta"})
public class svCarta extends HttpServlet {
    
    ControladoraLogica ctrl = new ControladoraLogica();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        List<Carta> listaCarta= new ArrayList<>();
        
        
        listaCarta = ctrl.listarCarta();
        
        HttpSession misesion = request.getSession();
        misesion.setAttribute("listaCarta", listaCarta);
        response.sendRedirect("mostrarCarta.jsp");
        
        
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        String nombre = request.getParameter("nombre");
        String categoria = request.getParameter("categoria");
        double precio = Double.parseDouble(request.getParameter("precio"));
        
        Carta car = new Carta();
        
        car.setNombreProducto(nombre);
        car.setCategoria(categoria);
        car.setPrecioProducto(precio);
        
        ctrl.crearCarta(car);
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
