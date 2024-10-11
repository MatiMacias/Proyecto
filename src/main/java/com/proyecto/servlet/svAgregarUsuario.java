package com.proyecto.servlet;

import com.proyecto.logica.ControladoraLogica;
import com.proyecto.logica.usuario;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "svAgregarUsuario", urlPatterns = {"/svAgregarUsuario"})
public class svAgregarUsuario extends HttpServlet {
    
    ControladoraLogica ctrl = new ControladoraLogica();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        List<usuario> listaUsuarios= new ArrayList<>();
        
        
        listaUsuarios = ctrl.listarUsuarios();
        
        HttpSession misesion = request.getSession();
        misesion.setAttribute("listaUsuarios", listaUsuarios);
        response.sendRedirect("mostrarUsuario.jsp");
        
        
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    
    // Recibir los parámetros del formulario
        String nombre = request.getParameter("nombre");
        String correo = request.getParameter("correo");
        String contrasena = request.getParameter("contrasena");
        String tipo = request.getParameter("tipo");

        // Crear una instancia de usuario
        usuario user = new usuario();

        user.setNombre(nombre);
        user.setCorreo(correo);
        user.setContrasena(contrasena);
        user.setTipo(tipo);
        
        // Llamar a la lógica para crear el usuario
        ctrl.crearUsuario(user);

        // Redirigir al formulario de registro
        response.sendRedirect("index.jsp");
    
    }
}
