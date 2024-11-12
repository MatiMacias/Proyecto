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
        <!-- Formulario para categorías -->
        <form id='form'>
            <label for="categoria">Nueva Categoría:</label>
            <input type="text" id="nuevaCategoria" name="nuevaCategoria">
            <button type="button" onclick="agregarCategoria()">Agregar Categoría</button>
            <br><br>

            <label>Seleccionar Categoría:</label>
            <select id="categoriaSeleccionada" name="categoriaSeleccionada"></select>
            <button type="button" onclick="eliminarCategoria()">Eliminar Categoría</button> <!-- Botón eliminar categoría --> 
        </form>

        <!-- Formulario para agregar producto -->
        <form action='svCarta' method='POST'>
            <label for="Categoria">Categoría:</label>
            <select id="Categoria" name="Categoria" required>
                <!-- Se cargarán categorías dinámicamente -->
            </select>
            
            <label for="nombreProducto">Nombre del Producto:</label>
            <input type="text" id="nombreProducto" name="nombreProducto" required>
            
            <label for="precioProducto">Precio:</label>
            <input type="number" step="0.01" id="precioProducto" name="precioProducto" required>
            
            <button type="submit">Agregar Producto</button>  
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
