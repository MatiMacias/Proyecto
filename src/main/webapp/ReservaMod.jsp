<%-- 
    Document   : ReservaMod
    Created on : 10-oct-2024, 22:16:52
    Author     : franc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modidficar Reserva</title>
    </head>
    <body>
        <% Reserva reserv = (Reserva) request.getSession().getAttribute("ReservaMod");%>
        <h1>Datos de la Reserva</h1>
        
        <form action="svReservaMod" method="POST">
            <p><label>Fecha:</label><input type="text" name="fecha" value="<%=reserv.getFecha()%>"></p>
            <p><label>Hora:</label><input type="text" name="hora" value="<%=reserv.getHora()%>"></p>
            <p><label>Mesa N°:</label><input type="text" name="numMesa" value="<%=reserv.getMesas()%>"></p>
            <button type="submit">Guardar</button>
        </form>
    </body>
</html>
