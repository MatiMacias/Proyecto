<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
    <!-- Custom CSS -->
    <link rel="stylesheet" type="text/css" href="style/login-style.css">
    <title>Iniciar Sesión</title>
</head>
<body>

    <nav class="navbar  navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="index.jsp" id="logo">Nombre X</a>
          </div>
    </nav>

    <section class="formulario col-md-2 col-lg-2">
        <div class="row">
            <form clas="user" action="svLogin" method="POST" >
                <label for="">Usuario</label> <br>
                <input type="text" name="user"> <br>
                <label for="">Contraseña</label><br>
                <input type="text" name="pass"><br>
                <div class="col-md-12 col-lg-12">
                <button id="boton">Iniciar Sesión</button>
                </div>
            </form> 
         </div>
    </section>


    <script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>