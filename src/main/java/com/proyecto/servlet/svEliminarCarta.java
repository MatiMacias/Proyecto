    
package com.proyecto.servlet;

import com.proyecto.logica.Carta;
import com.proyecto.logica.ControladoraLogica;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Santi
 */

@WebServlet(name = "svEliminarCarta", urlPatterns = {"/svEliminarCarta"})
public class svEliminarCarta extends HttpServlet {
    
    ControladoraLogica ctrl = new ControladoraLogica();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
         String nombreProducto = request.getParameter("nombreProducto"); // Obtén el nombre del producto de la solicitud

        if (nombreProducto != null && !nombreProducto.isEmpty()) {
            // Busca el producto por su nombre
            Carta prod = ctrl.buscarCartaNombre(nombreProducto);
            
            if (prod != null) {
                int idCarta = prod.getIdProducto();
                
                // Elimina el producto de la base de datos
                ctrl.borrarCarta(idCarta);
                
                // Responde con un mensaje de éxito
                response.getWriter().write("Producto eliminado correctamente");
            } else {
                // Si no se encuentra el producto
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Producto no encontrado");
            }
        } else {
            // Si no se proporciona un nombre de producto
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Nombre del producto no proporcionado");
        }
        
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
