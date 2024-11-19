/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.proyecto.servlet;

import com.google.gson.Gson;
import com.proyecto.logica.Carta;
import com.proyecto.logica.Categoria;
import com.proyecto.logica.ControladoraLogica;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "svCategoria", urlPatterns = {"/svCategoria"})
public class svCategoria extends HttpServlet {
    
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
        
        List<Categoria> categorias = ctrl.listarCategoria();
        
        List<String> nombresCategorias = new ArrayList<>();
        for(Categoria categoria : categorias){
            nombresCategorias.add(categoria.getNombre());
        }
        
        String json = new Gson().toJson(nombresCategorias);
        
        response.getWriter().write(json);
        
        
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        String nombre = request.getParameter("nuevaCategoria");
        
        
        Categoria cate = new Categoria();
        
        cate.setNombre(nombre);
        
        ctrl.crearCategoria(cate);
        
        response.sendRedirect("carta.jsp");
        
    }
    

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
