/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
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
import jakarta.servlet.http.HttpSession;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;
import java.util.Date;
import com.proyecto.logica.Reserva;

/**
 *
 * @author franc
 */
@WebServlet(name = "svReserva", urlPatterns = {"/svReserva"})
public class svReserva extends HttpServlet {
    
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
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Reserva> listaReservas = new ArrayList<>();
        listaReservas = logica.traerReservas();
        
        HttpSession misesion = request.getSession();
        misesion.setAttribute("listaReservas", listaReservas);
        
        response.sendRedirect("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fecha = request.getParameter("fecha");
        String hora = request.getParameter("hora");
        String mesas = request.getParameter("numMesa");
        
        Date fechadate = Date.from(Instant.parse(fecha));
        Calendar cal = Calendar.getInstance();
        cal.setTime(fechadate);
        
        Reserva res = new Reserva();
        res.setFecha(cal);
        res.setHora(Date.from(Instant.parse(hora)));
        //res.setMesas(Integer.parseInt(mesas));
        
        logica.crearReserva(res);
        response.sendRedirect("ReservaCarga.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
