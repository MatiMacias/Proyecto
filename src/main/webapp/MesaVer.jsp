<%-- 
    Document   : MesaVer
    Created on : 10-oct-2024, 20:51:23
    Author     : franc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mostrar Mesas</title>
    </head>
    <body>
        <h1>Listado de Mesas</h1>
        <%
            List<Mesa> listaMesas = (List) request.getSession().getAttribute("listaMesas");
            int cont = 1;
            for (Mesa mesas : listaMesas) {
        %>
        
        <p>Mesa N°: <%=mesas.getNumMesa()%></p>
        <p>Estado: <%=mesas.getEstado()%></p>
        <p>Reserva: <%=mesas.getReserva()%></p>

        <% cont = cont + 1;
        }%>
    </body>
</html>
