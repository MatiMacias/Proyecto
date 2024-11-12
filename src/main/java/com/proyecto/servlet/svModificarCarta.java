package com.proyecto.servlet;

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
        
        int idMod = Integer.parseInt(request.getParameter("idCartaMod"));
        
        Carta carta = ctrl.buscarCarta(idMod);
        
        HttpSession miSesion = request.getSession();
        miSesion.setAttribute("cartaMod", carta);
        
        response.sendRedirect("modificarCarta.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        String nombre = request.getParameter("nombre");
        
        Carta carta = (Carta) request.getSession().getAttribute("cartaMod");

        carta.setNombreProducto(nombre);

        ctrl.modificarCarta(carta);
        
        response.sendRedirect("index.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
