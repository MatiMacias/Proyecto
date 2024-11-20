/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.proyecto.servlet;

import com.google.gson.Gson;
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
        
        
        List<Mesa> mesas = logica.listarMesas();
        
        Gson gson = new Gson();
        String json = gson.toJson(mesas);
        
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
        
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int numeroMesa = Integer.parseInt(request.getParameter("numeroMesa"));
        
        Mesa mesa = new Mesa();
        mesa.setNumMesa(numeroMesa);
        mesa.setEstado("disponible");
        
        logica.crearMesa(mesa);
        response.sendRedirect("mesas.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
