<%-- 
    Document   : mostrarCarta
    Created on : 7 oct. 2024, 21:52:29
    Author     : Matias
--%>

<%@page import="java.util.List"%>
<%@page import="com.proyecto.logica.Carta"%>
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
        
            List<Carta> listaCarta= (List) request.getSession().getAttribute("listaCarta");
            int cont = 1;
            for(Carta car : listaCarta){
        %>  <p>Producto Nro: <%=cont%></p>
            <p>ID: <%=car.getIdProducto()%></p>
            <p>DNI: <%=car.getCategoria()%></p>
            <p>Nombre: <%=car.getNombreProducto()%></p>
            <p>Apellido: <%=car.getPrecioProducto()%></p>
            
            <p>--------------------------------------------</p>
            
            <% cont = cont+1; }%>
                    
        
        
    </body>
</html>
