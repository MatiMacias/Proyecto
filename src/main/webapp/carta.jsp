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
        
        <form>
            
        </form>
        <input type="text" id="buscarProducto" placeholder="Buscar Producto por Nombre">
        <button id="buscarBtn">Buscar Producto</button>
        
        <input type="text" id="nombreNuevo" placeholder="Nuevo nombre">
        <input type="number" id="precioNuevo" placeholder="Nuevo Precio">
        <button id="enviarDatos">Modificar producto</button>
        
        
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
        $(document).ready(function(){
            actualizarProductos();
        });
        
        
    // Función para actualizar la lista de productos
        function actualizarProductos() {
            $.ajax({
                url: 'dataProductos',  // El endpoint que te da los productos
                method: 'GET',
                success: function(response) {
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
                                    let productoItem = $('<li>')
                                        .text(producto.nombre + ' - $' + producto.precio)
                                        .appendTo(productosLista);

                                    // Agregar un botón de eliminar para cada producto
                                    let eliminarBtn = $('<button>')
                                        .text('Eliminar')
                                        .click(function() {
                                            eliminarProducto(producto.nombre);  // Llamar a la función de eliminación
                                        });
                                    productoItem.append(eliminarBtn);
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
        }

            function eliminarProducto(nombreProducto) {
    $.ajax({
        url: 'svEliminarCarta', // El servlet que maneja la eliminación
        method: 'POST',
        data: { nombreProducto: nombreProducto },
        success: function(response) {
            // Aquí puedes hacer algo con la respuesta si es necesario
            alert("Producto eliminado correctamente");
            // Actualizar la lista de productos
            actualizarProductos();
        },
        error: function(xhr, status, error) {
            console.error("Error al eliminar el producto: ", error);
            alert("No se pudo eliminar el producto.");
        }
    });
}

    
    
    $(document).ready(function() {
    // Función para buscar el producto
    $('#buscarBtn').click(function() {
        var nombreProducto = $('#buscarProducto').val();  // Obtén el nombre del producto a buscar

        // Verifica si se ingresó el nombre del producto
        if (!nombreProducto) {
            alert("Por favor ingresa el nombre del producto a buscar.");
            return;
        }

        // Realiza la solicitud AJAX para buscar el producto
        $.ajax({
            url: 'svModificarCarta',  // Servlet donde buscarás el producto
            method: 'GET',  // Método GET para buscar datos
            data: { nombreProducto: nombreProducto },  // Enviar el nombre del producto como parámetro
            success: function(response) {
                // response ya es un objeto JSON, puedes acceder a él directamente
                if (response) {
                    $('#nombreNuevo').val(response.nombreProducto);  // Completa el nombre
                    $('#precioNuevo').val(response.precioProducto);  // Completa el precio
                } else {
                    alert("Producto no encontrado.");
                }
            },
            error: function(xhr, status, error) {
                console.error("Error al buscar el producto: ", error);
                alert("Hubo un error al buscar el producto.");
            }
        });
    });

    // Función para modificar el producto
    $('#enviarDatos').click(function() {
        var nombreProducto = $('#nombreNuevo').val();
        var precioProducto = $('#precioNuevo').val();

        // Verifica que los campos no estén vacíos
        if (!nombreProducto || !precioProducto) {
            alert("Por favor ingrese todos los campos.");
            return;
        }

        // Realiza la solicitud AJAX para modificar el producto
        $.ajax({
            url: 'svModificarCarta',  // Servlet para modificar el producto
            method: 'POST',  // Método POST para modificar datos
            data: {
                nombreProducto: nombreProducto,
                precioProducto: precioProducto
            },
            success: function(response) {
                alert(response);  // Mostrar la respuesta del servidor (modificación exitosa)
            },
            error: function(xhr, status, error) {
                console.error('Error al modificar el producto: ', error);
                alert('Hubo un error al modificar el producto');
            }
        });
    });
});





    </script>
   
</body>
</html>
