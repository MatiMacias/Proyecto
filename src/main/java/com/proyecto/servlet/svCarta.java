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
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Santi
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
        
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // Simulando datos de productos (deberías cargarlos desde la base de datos)
        List<Carta> productos = ctrl.listarCartas();

        // Convertir lista a JSON usando Gson
        Gson gson = new Gson();
        String json = gson.toJson(productos);

        // Escribir la respuesta
        PrintWriter out = response.getWriter();
        out.print(json);
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        String categoria = request.getParameter("categoriasSelect");
        String nombre = request.getParameter("nombreProducto");
        Double precio = Double.parseDouble(request.getParameter("precioProducto"));
        
        Carta carta = new Carta();
        
        Categoria cate = ctrl.buscarCategoriaNombre(categoria);
        
        carta.setNombreProducto(nombre);
        carta.setPrecioProducto(precio);
        carta.setCategoria(cate);

        ctrl.crearCarta(carta);
        
        response.sendRedirect("carta.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
