<%-- 
    Document   : index
    Created on : 27 sep. 2024, 19:58:41
    Author     : Matias
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Probando CRUD Carta</h1>
        
        <form action='svCarta' method='POST'>
            <p><label>nombre: </label><input type="text" name="nombre"></p>
            <p><label>categoria: </label><input type="text" name="categoria"></p>
            <p><label>precio: </label><input type="text" name="precio"></p>
            <input type="submit" value="ENVIAR" />
        </form>
        
        <h2>Datos de Carta</h2>
        <p>Para visualizar aprete el boton</p>
        <form action='svCarta' method='GET'>
            <button type='submit'>MOSTRAR</button>
        </form>
        
        <h1>Borrar Producuto</h1>
        <p>Ingrese el ID del estudiante a borrar</p>
        <form action='svEliminarCarta' method='POST'>    
            <p><label>ID:  </label><input type="text" name="idCarta"></p>
            <input type="submit" value="Borrar" />
        </form>
        
        <h1>Modificar un Producto</h1>
        <p> Ingrese el Id del estudiante que desea Modificar</p> 
        <form action='svModificarCarta' method='GET' >
            <p><label> ID:</label><input type="text" name="idCartaMod"> </p>
            <input type='submit' value="Modificar" /> 
        </form>
        
    </body>
</html>
