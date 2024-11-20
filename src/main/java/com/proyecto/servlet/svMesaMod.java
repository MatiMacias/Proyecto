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

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

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

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Obtener los parámetros enviados desde el front-end
        String mesaNum = request.getParameter("mesaNum");
        String estado = request.getParameter("estado");

        try {
            // Buscar la mesa por su número
            Mesa mesa = logica.buscarMesa(Integer.valueOf(mesaNum)); // Asegúrate de que esto se haga correctamente

            if (mesa != null) {
                // Cambiar el estado de la mesa
                mesa.setEstado(estado);

                // Modificar la mesa en la base de datos
                logica.modificarMesa(mesa); 

                // Responder al cliente con un mensaje de éxito
                response.getWriter().write("Estado actualizado correctamente");
            } else {
                // Si no se encuentra la mesa, respondemos con error
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Mesa no encontrada");
            }
        } catch (Exception e) {
            // Si ocurre un error, respondemos con error interno
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al actualizar el estado de la mesa");
        }
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
