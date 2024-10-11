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
import java.io.PrintWriter;
import com.proyecto.logica.Mesa;


/**
 *
 * @author franc
 */
@WebServlet(name = "svMesaMod", urlPatterns = {"/svMesaMod"})
public class svMesaMod extends HttpServlet {
    
    ControladoraLogica logica = new ControladoraLogica();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int idMesaMod = Integer.parseInt(request.getParameter("nMesaMod"));
        
        Mesa mesa = logica.buscarMesa(idMesaMod);
        // Para pasar los datos conservamos la sesión
        HttpSession misesion = request.getSession();
        misesion.setAttribute("MesaMod", mesa);
        // Redireccionamos al nuevo jsp2 creado
        response.sendRedirect("MesaMod.jsp");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String numMesa = request.getParameter("numMesa");
        String estado = request.getParameter("estado");
        //String reserva = request.getParameter("reserva");
        
        Mesa mesa = new Mesa();
        mesa.setNumMesa(Integer.parseInt(numMesa));
        mesa.setEstado(estado);
        //mesa.setReserva(reserva);
        // Llamamos el metodo modificarEstudiante de la controladora logica (lo creamos si no existe)
        logica.modificarMesa(mesa);
        // Redireccionamos al index
        response.sendRedirect("MesaCarga.jsp");
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
