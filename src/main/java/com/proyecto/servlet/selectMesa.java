package com.proyecto.servlet;

import com.google.gson.Gson;
import com.proyecto.logica.ControladoraLogica;
import com.proyecto.logica.Mesa;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Matias
 */
@WebServlet(name = "selectMesa", urlPatterns = {"/selectMesa"})
public class selectMesa extends HttpServlet {
    
    ControladoraLogica ctrl = new ControladoraLogica();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
         response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        List<Mesa> mesas = ctrl.listarMesas();
       
        List<Integer> numeroMesas = new ArrayList<>();
        for(Mesa mesa : mesas){
            numeroMesas.add(Integer.valueOf(mesa.getNumMesa()));
        }
        
        String json = new Gson().toJson(numeroMesas);
        
        response.getWriter().write(json);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
