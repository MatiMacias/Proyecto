/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.proyecto.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.proyecto.logica.Carta;
import com.proyecto.logica.ControladoraLogica;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Matias
 */
@WebServlet(name = "dataProductos", urlPatterns = {"/dataProductos"})
public class dataProductos extends HttpServlet {

    ControladoraLogica ctrl = new ControladoraLogica();
 
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
              
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
     
         List<Carta> productos = ctrl.listarCartas(); // Obtener productos desde la base de datos
        Map<String, List<Map<String, Object>>> productosPorCategoria = new HashMap<>();
        
        // Separar productos por categoría
        for (Carta producto : productos) {
            String categoriaNombre = producto.getCategoria().getNombre();
            if (!productosPorCategoria.containsKey(categoriaNombre)) {
                productosPorCategoria.put(categoriaNombre, new ArrayList<>());
            }

            // Crear un mapa con los datos de cada producto
            Map<String, Object> productoData = new HashMap<>();
            productoData.put("nombre", producto.getNombreProducto());
            productoData.put("precio", producto.getPrecioProducto());

            // Agregar el producto a la categoría correspondiente
            productosPorCategoria.get(categoriaNombre).add(productoData);
        }

        // Convertir la respuesta a JSON usando Jackson
        ObjectMapper mapper = new ObjectMapper();
        String jsonResponse = mapper.writeValueAsString(productosPorCategoria);

        // Establecer el tipo de contenido como JSON y enviar la respuesta
        response.setContentType("application/json");
        response.getWriter().write(jsonResponse);
      
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
