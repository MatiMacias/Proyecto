<%-- 
    Document   : MesaMod
    Created on : 09-oct-2024, 21:40:38
    Author     : franc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar Mesas</title>
    </head>
    <body>
        <% Mesa mesas = (Mesa) request.getSession().getAttribute("MesaMod");%>
        <h1>Datos del Estudiante</h1>
        
        <form action="svMesaMod" method="POST">
            <p><label>N° Mesa:</label><input type="text" name="numMesa" value="<%=mesas.getNumMesa()%>"></p>
            <p><label>Nombre:</label><input type="text" name="estado" value="<%=mesas.getEstado()%>"></p>
            <p><label>Apellido:</label><input type="text" name="reserva" value="<%=mesas.getReserva()%>"></p>
            <button type="submit">Guardar</button>
        </form>
        
    </body>
</html>
