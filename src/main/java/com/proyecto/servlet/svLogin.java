package com.proyecto.servlet;

import com.proyecto.logica.ControladoraLogica;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet(name = "svLogin", urlPatterns = {"/svLogin"})
public class svLogin extends HttpServlet {
    
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
        
        String usuario = request.getParameter("user");
        String contraena = request.getParameter("pass");
        
        boolean validacion = false;
        validacion = ctrl.validarIngreso(usuario, contraena);
        
        if(validacion == true){
        HttpSession misesion = request.getSession(true);
        misesion.setAttribute("usuario", usuario);
        response.sendRedirect("dashboard.jsp");
        }else{
            response.sendRedirect("index.jsp");
        }
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
