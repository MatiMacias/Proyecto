<%-- 
    Document   : mostrarPedidos
    Created on : 10/10/2024, 21:10:29
    Author     : Brython
--%>

<%@page import="com.proyecto.logica.Pedido"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Pedidos realizados</h1>
        
          <% 
        
            List<Pedido> listaPedido= (List) request.getSession().getAttribute("listaPedido");
            int cont = 1;
            for(Pedido enco : listaPedido){
        %>  <p>Producto Nro: <%=cont%></p>
            <p>Id: <%=enco.getIdPedido()%></p>
            <p>Total: <%=enco.getTotalPedido()%></p>
            <p>Horario: <%=enco.getHoraPedido()%></p>
            
            <p>--------------------------------------------</p>
            
            <% cont = cont+1; }%>
                    
        
        
    </body>
</html>
