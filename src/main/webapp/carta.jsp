<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Stock</title>
    <!-- Custom CSS -->
    <link rel="stylesheet" href="style/carta-style.css">
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-md">
          <a class="navbar-brand" href="#" id="logo">Nombre X</a>
        </div>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav ms-auto">
              <a class="nav-link" href="dashboard.jsp" id="cierre"><button class="sesion">Volver</button></a>
            </div>
        </div>
      </nav>
      <div id="titulo">
        <h1>Altas de productos</h1>
      </div>
    <div class="container">
        <form id="form">
            <label for="categoria">Nueva Categoría:</label>
            <input type="text" id="nuevaCategoria" name="nuevaCategoria">
            <button type="button" onclick="agregarCategoria()">Agregar Categoría</button>
            <br><br>

            <label>Seleccionar Categoría:</label>
            <select id="categoriaSeleccionada" name="categoriaSeleccionada"></select>
            <button type="button" onclick="eliminarCategoria()">Eliminar Categoría</button> <!-- Botón eliminar categoría -->
            
            <label for="nombre">Nombre:</label>
            <input type="text" id="nombre" name="nombre" required>
            <label for="precio">Precio:</label>
            <input type="text" id="precio" name="precio">
            <button type="button" onclick="agregarElemento()">Agregar Producto</button>
        </form>

        <div id="listas" class="grid-container">
            <!-- Las listas dinámicas se agregarán aquí -->
        </div>
    </div>

    <link href="https://unpkg.com/tabulator-tables@6.2.5/dist/css/tabulator.min.css" rel="stylesheet">
    <script type="text/javascript" src="https://unpkg.com/tabulator-tables@6.2.5/dist/js/tabulator.min.js"></script>
    <script src="js/AltasBajas.js"></script>
</body>
</html>
