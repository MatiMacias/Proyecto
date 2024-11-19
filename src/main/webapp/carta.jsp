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
        <form id='form' action='svCategoria' method='POST'>
            <label for="categoria">Nueva Categoría:</label>
            <input type="text" id="nuevaCategoria" name="nuevaCategoria">
            <button type="submit">Agregar Categoria</button>
            <br><br>
        </form>

        <!-- Formulario para agregar producto -->
        
        
        <form action='svCarta' method='POST'>
            <label for="Categoria">Categoría:</label>
            <select id="categoriasSelect" name="categoriasSelect">
                <!-- Se cargarán categorías dinámicamente -->
            </select>
            
            
            <label for="nombreProducto">Nombre del Producto:</label>
            
            <input type="text" id="nombreProducto" name="nombreProducto" >
            
            <label for="precioProducto">Precio:</label>
            <input type="number" step="0.01" id="precioProducto" name="precioProducto" >
            
            <button type="submit">Agregar Producto</button>
            </div>
        </form>
        
        
        <h1>Productos Disponibles por Categoría</h1>
    <div id="productos-container"></div>

    <link href="https://unpkg.com/tabulator-tables@6.2.5/dist/css/tabulator.min.css" rel="stylesheet">
    <script type="text/javascript" src="https://unpkg.com/tabulator-tables@6.2.5/dist/js/tabulator.min.js"></script>
    <script src="js/jquery-3.7.1.min.js"></script>
    
    <script>
        $(document).ready(function() {
    $.ajax({
        url: 'svCategoria', // URL del servlet
        type: 'GET',
        dataType: 'json', // Tipo de respuesta esperado
        success: function(data) {
            // Limpiar el <select>
            $("#categoriasSelect").empty();
            
            // Añadir una opción predeterminada
            $("#categoriasSelect").append('<option value="">Seleccione una categoría</option>');
            
            // Recorrer los nombres de las categorías y añadirlos al <select>
            data.forEach(function(nombreCategoria) {
                $("#categoriasSelect").append(
                    '<option value="' + nombreCategoria + '">' + nombreCategoria + '</option>'
                );
            });
        },
        error: function(xhr, status, error) {
            console.error("Error al cargar las categorías: ", error);
        }
    });
});
    </script>

    <script>
    $(document).ready(function() {
    // Hacer una solicitud AJAX al Servlet
    $.ajax({
        url: 'dataProductos',  // El servlet que has creado
        method: 'GET',
        success: function(response) {
            // La respuesta es un objeto que contiene categorías y productos
            // Ejemplo: response = { "Pizzas": [...productos], "Bebidas": [...productos], ... }

            // Limpiar contenido previo
            $('#productos-container').empty();

            // Iterar sobre las categorías y sus productos
            for (const categoria in response) {
                if (response.hasOwnProperty(categoria)) {
                    const productos = response[categoria];

                    // Crear un contenedor para cada categoría
                    let categoriaDiv = $('<div>').addClass('categoria');
                    let categoriaTitulo = $('<h3>').text(categoria).appendTo(categoriaDiv);

                    // Crear un contenedor para los productos de esa categoría
                    let productosLista = $('<ul>').appendTo(categoriaDiv);

                    // Iterar sobre los productos y mostrarlos
                    productos.forEach(function(producto) {
                        // Verifica que producto tenga las propiedades 'nombre' y 'precio'
                        if (producto.nombre && producto.precio) {
                            let productoItem = $('<li>').text(producto.nombre + ' - $' + producto.precio);
                            productosLista.append(productoItem);
                        }
                    });

                    // Agregar el contenedor de la categoría al contenedor principal
                    $('#productos-container').append(categoriaDiv);
                }
            }
        },
        error: function(xhr, status, error) {
            console.error("Error al obtener los productos: ", error);
        }
    });
});
    </script>
   
</body>
</html>
