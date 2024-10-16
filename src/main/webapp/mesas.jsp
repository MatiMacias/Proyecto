<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mesas</title>
        <!-- Custom CSS -->
        <link rel="stylesheet" href="style/mesas-style.css">
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-md">
          <a class="navbar-brand" href="#" id="logo">Nombre X</a>
        </div>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="regreso">
              <a class="nav-link" href="dashboard.jsp" id="cierre"><button class="sesion">Volver</button></a>
            </div>
        </div>
      </nav>
    <form id="formMesas">
        <label for="numeroMesas">Número de Mesas:</label>
        <input type="number" id="numeroMesas" min="1" required>
        <button type="submit">Generar Mesas</button>
    </form>
    <div id="tablaMesas">
        <table class="table table-bordered border-primary">
            <tr>
            <td>mesa 1</td>
            <td>mesa 1</td>
            <td>mesa 1</td>
            <td>mesa 1</td>  
            </tr>
            <tr>
            <td>mesa 1</td>
            <td>mesa 1</td>
            <td>mesa 1</td>
            <td>mesa 1</td>  
            </tr>
            
        </table>
    </div>
</body>
</html>