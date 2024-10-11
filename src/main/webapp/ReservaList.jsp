<%-- 
    Document   : ReservaList
    Created on : 10-oct-2024, 22:17:03
    Author     : franc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mostrar Reservas</title>
    </head>
    <body>
        <h1>Listado de Reservas</h1>
        <%
            List<Reserva> listaReservas = (List) request.getSession().getAttribute("listaReservas");
            int cont = 1;
            for (Reserva rev : listaReservas) {
        %>
        
        <p>Fecha: <%=mesas.getFecha()%></p>
        <p>Hora: <%=mesas.getHora()%></p>
        <p>Mesa N°: <%=mesas.getMesas()%></p>

        <% cont = cont + 1;
        }%>
    </body>
</html>
