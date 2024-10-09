/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.proyecto.servlet;

import com.proyecto.logica.Carta;
import com.proyecto.logica.ControladoraLogica;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet(name = "svModificarCarta", urlPatterns = {"/svModificarCarta"})
public class svModificarCarta extends HttpServlet {

    ControladoraLogica ctrl = new  ControladoraLogica();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        int idMod = Integer.parseInt(request.getParameter("idCartaMod"));
        
        Carta car = ctrl.buscarCarta(idMod);
        
        HttpSession miSesion = request.getSession();
        miSesion.setAttribute("cartaMod", car);
        
        response.sendRedirect("modificarCarta.jsp");
        
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        String categoria = request.getParameter("categoria");
        String nombre = request.getParameter("nombre");
        double precio = Double.parseDouble(request.getParameter("Precio"));
        
        Carta car = (Carta) request.getSession().getAttribute("cartaMod");
        
        car.setCategoria(categoria);
        car.setNombreProducto(nombre);
        car.setPrecioProducto(precio);
        
        ctrl.modificarCarta(car);
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
