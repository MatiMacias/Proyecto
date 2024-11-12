package com.proyecto.servlet;

import com.proyecto.logica.Carta;
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
        
        List<Carta> listaCartas = new ArrayList<>();
        
        listaCartas = ctrl.listarCartas();
        
        HttpSession misesion = request.getSession();
        misesion.setAttribute("listaCarta", listaCartas);
        response.sendRedirect("mostrarCarta.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        String nombre = request.getParameter("nombre");
        
        Carta carta = new Carta();
        
        // Se pueden agregar más campos a la carta aquí si es necesario.
        
        carta.setNombreProducto(nombre);

        ctrl.crearCarta(carta);
        
        response.sendRedirect("datosCarta.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
