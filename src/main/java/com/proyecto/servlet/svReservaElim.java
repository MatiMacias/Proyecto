/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.proyecto.servlet;

import com.proyecto.logica.ControladoraLogica;
import com.proyecto.logica.Mesa;
import com.proyecto.logica.Reserva;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author franc
 */
@WebServlet(name = "svReservaElim", urlPatterns = {"/svReservaElim"})
public class svReservaElim extends HttpServlet {
    
    ControladoraLogica logica = new ControladoraLogica();

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        try {
        int idReservaBorrar = Integer.parseInt(request.getParameter("idReserva"));
        Reserva res = logica.buscarReserva(idReservaBorrar);
        int numMesa = res.getMesas().getNumMesa();
        logica.borrarReserva(idReservaBorrar); // Método para eliminar la reserva en la lógica
        response.getWriter().write("Reserva eliminada correctamente");
        Mesa mesa = logica.buscarMesa(numMesa);
        mesa.setEstado("disponible");
        logica.modificarMesa(mesa);
    } catch (NumberFormatException e) {
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID de reserva inválido");
        e.printStackTrace();
    } catch (Exception e) {
        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al eliminar la reserva");
        e.printStackTrace();
    }    
            
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
