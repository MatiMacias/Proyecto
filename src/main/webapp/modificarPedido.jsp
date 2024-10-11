<%-- 
    Document   : modificarPedido
    Created on : 10/10/2024, 21:43:37
    Author     : Brython
--%>

<%@page import="com.proyecto.logica.Pedido"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Vista</h1>
        
        <%Pedido enco = (Pedido) request.getSession().getAttribute("pedidoMod");%>       

            <h1>Pedidos realizados</h1>
                <form action='svModificarPedido' method='POST'>
                    <p><label>Total: </label><input type="text" name="categoria" value="<%=enco.getTotalPedido()%>"></p>
                    <p><label>Horario: </label><input type="text" name="nombre" value="<%=enco.getHoraPedido()%>"></p>
                    <input type="submit" value="ENVIAR" />
                </form>
        
    </body>
</html>
