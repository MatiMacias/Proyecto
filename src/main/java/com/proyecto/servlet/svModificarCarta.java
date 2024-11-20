package com.proyecto.servlet;

import com.google.gson.Gson;
import com.proyecto.logica.Carta;
import com.proyecto.logica.ControladoraLogica;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author Santi
 */

@WebServlet(name = "svModificarCarta", urlPatterns = {"/svModificarCarta"})
public class svModificarCarta extends HttpServlet {
    
    ControladoraLogica ctrl = new ControladoraLogica();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
         String nombre = request.getParameter("nombreProducto");  // Obtener el nombre del producto
        Carta carta = ctrl.buscarCartaNombre(nombre);  // Buscar el producto en la base de datos

        if (carta != null) {
            // Configurar el tipo de contenido como JSON
            response.setContentType("application/json");

            // Usar Gson para convertir el objeto a JSON
            Gson gson = new Gson();
            String jsonResponse = gson.toJson(carta); // Convertir el objeto 'carta' a JSON

            // Enviar el JSON como respuesta
            response.getWriter().write(jsonResponse);
        } else {
            // Si no se encuentra el producto, responder con un mensaje de error
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            response.getWriter().write("{\"message\":\"Producto no encontrado\"}");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        String nombre = request.getParameter("nombreProducto");
        double precio = Double.parseDouble(request.getParameter("precioProducto"));
        
        // Buscar el producto por nombre
        Carta carta = ctrl.buscarCartaNombre(nombre);

        if (carta != null) {
            // Si se encuentra el producto, se actualiza
            carta.setNombreProducto(nombre);
            carta.setPrecioProducto(precio);
            ctrl.modificarCarta(carta);
            
            // Responder con un mensaje de éxito
            response.setContentType("text/plain");
            response.getWriter().write("Producto modificado correctamente");
        } else {
            // Si no se encuentra el producto, responder con error
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            response.getWriter().write("{\"message\":\"Producto no encontrado\"}");
        }
 
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
