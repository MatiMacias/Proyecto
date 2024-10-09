<%-- 
    Document   : modificarCarta
    Created on : 7 oct. 2024, 22:01:13
    Author     : Matias
--%>

<%@page import="com.proyecto.logica.Carta"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Vista</h1>
        
        <%Carta car = (Carta) request.getSession().getAttribute("cartaMod");%>       

            <h1>Producto de la Carta</h1>
                <form action='svModificarCarta' method='POST'>
                    <p><label>Categoria </label><input type="text" name="categoria" value="<%=car.getCategoria()%>"></p>
                    <p><label>Nombre: </label><input type="text" name="nombre" value="<%=car.getNombreProducto()%>"></p>
                    <p><label>Precio: </label><input type="text" name="precio" value="<%=car.getPrecioProducto()%>"></p>
                    <input type="submit" value="ENVIAR" />
                </form>
        
    </body>
</html>
