<%-- 
    Document   : ReservaCarga
    Created on : 10-oct-2024, 22:16:37
    Author     : franc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reservas</title>
    </head>
    <body>
        <h1>Hacer Reservas</h1>
        <h1>Cargar Reserva</h1>
        <form action="svReserva" method="POST">
            <p><label>Fecha:</label><input type="Date" name="fecha"></p>
            <p><label>Hora:</label><input type="Time" name="hora"></p>
            <p><label>N° de Mesa:</label><input type="text" name="numMesa"></p>
            <button type="submit">Crear Reserva</button>
            
        </form>
        
        <h1>Ver datos de las Reservas</h1>
        <p>Para visualizar los  datos hacer click en el botón.</p>
        <form action="svReserva" method="GET">
            <button type="submit">Mostrar Reservas</button>
        </form>
        
        <h1>Eliminar Reserva</h1>
        <p>Ingrese el id de la reserva que desea borrar</p>
        <form action="svReservaElim" method="POST">
            <p><label>ID Reserva: </label><input type="text" name="idReserva"></p>
            <button type="submit">Borrar Mesa</button>
        </form>
        
        <h1>Modificar Reserva</h1>
        <p>Ingrese el id de la reserva que desea modificar</p>
        <form action="svReservaMod" method="GET">
            <p><label>ID Reserva: </label><input type="text" name="idReservaMod"></p>
            <button type="submit">Modificar Reserva</button>
        </form>
    </body>
</html>
