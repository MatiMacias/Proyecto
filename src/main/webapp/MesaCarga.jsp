<%-- 
    Document   : MesaCarga
    Created on : 09-oct-2024, 21:40:24
    Author     : franc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestión de Mesas</title>
    </head>
    <body>
        <h1>Gestión de Mesas</h1>
        <h1>Cargar Mesas</h1>
        <form action='svMesa' method='POST'>
            <p><label>N° de Mesa:</label><input type="text" name="numMesa"></p>
            <p><label>Estado:</label><input type="text" name="estado"></p>
            <!--<p><label>Reserva:</label><input type="datetime-local" name="reserva"></p>-->
            <button type="submit">Crear</button>
        </form>
        
        <h1>Ver datos de las Mesas</h1>
        <p>Para visualizar los  datos hacer click en el botón.</p>
        <form action="svMesa" method="GET">
            <button type="submit">Mostrar</button>
        </form>
        
        <h1>Borrar Mesa</h1>
        <p>Ingrese el N° de la mesa que desea borrar</p>
        <form action="svMesaElim" method="POST">
            <p><label>N° Mesa: </label><input type="text" name="numMesa"></p>
            <button type="submit">Borrar Mesa</button>
        </form>
        
        <h1>Modificar Mesa</h1>
        <p>Ingrese el N° de la mesa que desea modificar</p>
        <form action="svMesaMod" method="GET">
            <p><label>N° Mesa: </label><input type="text" name="nMesaMod"></p>
            <button type="submit">Editar Mesa</button>
        </form>
    </body>
</html>
