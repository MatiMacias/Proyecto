/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.proyecto.servlet;

import com.proyecto.logica.ControladoraLogica;
import com.proyecto.logica.Mesa;
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
import com.proyecto.logica.usuario;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author franc
 */
@WebServlet(name = "svReserva", urlPatterns = {"/svReserva"})
public class svReserva extends HttpServlet {
    
    ControladoraLogica logica = new ControladoraLogica();

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
        
        response.sendRedirect("mostrarReserva.jsp");
        
        List<Mesa> mesas = logica.listarMesas();
        
        
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nom");
        String apellido = request.getParameter("ape");
        String telefono = request.getParameter("tel");
        String fecha = request.getParameter("fecRes");
        String hora = request.getParameter("horaRes");
        int comensales = Integer.parseInt(request.getParameter("comen"));
        
        String mesas = request.getParameter("mesa");
        Mesa mesa = logica.buscarMesa(Integer.valueOf(mesas));
        
        mesa.setEstado("reservada");
        logica.modificarMesa(mesa);
        
                // Parsear la fecha
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        Date fechadate = null;
        try {
            fechadate = dateFormatter.parse(fecha);
        } catch (ParseException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Formato de fecha inválido");
            return;
        }

        // Convertir a Calendar
        Calendar cal = Calendar.getInstance();
        cal.setTime(fechadate);

        // Parsear la hora
        SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm");
        Date horaDate = null;
        try {
            horaDate = timeFormatter.parse(hora);
        } catch (ParseException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Formato de hora inválido");
            return;
        }
        
        
        Reserva res = new Reserva();
        res.setNombre(nombre);
        res.setApellido(apellido);
        res.setTelefono(telefono);
        res.setFecha(cal);
        res.setHora(horaDate);
        res.setMesas(mesa);
        
                
        
        logica.crearReserva(res);
        response.sendRedirect("dashboard.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
