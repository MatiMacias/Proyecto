<%-- 
    Document   : mostrarCarta
    Created on : 7 oct. 2024, 21:52:29
    Author     : Matias
--%>

<%@page import="java.util.List"%>
<%@page import="com.proyecto.logica.usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Productos de la carta</h1>
        
          <% 
        
            List<usuario> listaUsuarios= (List) request.getSession().getAttribute("listaUsuarios");
            int cont = 1;
            for(usuario user : listaUsuarios){
        %>  
            <p>ID: <%=user.getId()%></p>
            <p>Nombre: <%=user.getNombre()%></p>
            <p>Correo: <%=user.getCorreo()%></p>
            
            <p>--------------------------------------------</p>
            
            <% cont = cont+1; }%>
                    
        
        
    </body>
</html>
