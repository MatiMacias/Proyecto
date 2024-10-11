/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.servlet;

import com.proyecto.logica.ControladoraLogica;
import com.proyecto.logica.Pedido;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Brython
 */
@WebServlet(name = "svModificarPedido", urlPatterns = {"/svModificarPedido"})
public class svModificarPedido extends HttpServlet {

    ControladoraLogica ctrlLogica = new ControladoraLogica();

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
        
        int idPedidoMod = Integer.parseInt(request.getParameter("idPedidoModificado"));
        
        Pedido enco = ctrlLogica.buscarPedido(idPedidoMod);
        
        HttpSession miSesion = (HttpSession) request.getSession();
        miSesion.setAttribute("pedidoMod", enco);
        
        response.sendRedirect("modificarPedido.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
