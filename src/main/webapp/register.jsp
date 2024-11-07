<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Custom CSS -->
    <link rel="stylesheet" type="text/css" href="style/login-style.css">
    <title>Registro</title>
    
</head>
<body>

    <nav class="navbar navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="index.jsp" id="logo">Nombre X</a>
          </div>
      </nav>

    <section class="formulario">
        <form name="registro" action="svRegister" method="POST">
            <label for="">Usuario</label> <br>
            <input type="text" name="usuario"> <br>
            <label for="">Contraseña</label><br>
            <input id="contra" name="contrasena" type="password" required><br>
            <label for="">Correo Electronico</label><br>
            <input id="email" name="email" type="text"><br>
            <button id="boton">Registrarse</button><br>
            <a href="login.jsp">Ya tengo una cuenta</a>
        </form>
    </section>
    