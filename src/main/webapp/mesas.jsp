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
    <form id="formMesas" name="fromMesas" action="svMesa" method="POST">
        <label for="numeroMesa">Número de la Mesa:</label>
        <input type="text" id="numeroMesa" name="numeroMesa" min="1" required>
        <button type="submit">Generar Mesa</button>
    </form>
    <div id="tablaMesas">
        
    </div>
    
    <script src="js/jquery-3.7.1.min.js"></script>
   <script>
    $(document).ready(function () {
        $.ajax({
            url: "svMesa",
            type: "GET",
            dataType: "json",
            success: function (data) {
                // Limpiar el contenedor donde se agregarán los botones
                $("#tablaMesas").empty();

                // Recorrer los números de las mesas y añadir un botón por cada uno
                data.forEach(function(mesas) {
                    const button = $('<button class="mesa-btn"></button>')
                        .text('Mesa ' + mesas.numMesa)
                        .data("numMesa", mesas.numMesa) // Asignamos el número de mesa
                        .data("estado", mesas.estado);

                    // Asignamos el color del botón según su estado
                    asignarColor(button, mesas.estado);
                    
                    // Añadimos el botón al contenedor
                    $("#tablaMesas").append(button);

                    // Asignamos la función de clic
                    button.on("click", function() {
                        alternarEstadoMesa($(this)); // Pasa el botón para cambiar el estado
                    });
                });
            }
        });
    });

    // Función para asignar el color del botón según el estado
    function asignarColor(button, estado) {
        if (estado === 'disponible') {
            button.css('background-color', 'green');
            button.css('color', 'white');
        } else if (estado === 'reservada') {
            button.css('background-color', 'gray');
            button.css('color', 'black');
        }
    }

    // Función para alternar el estado de la mesa
    function alternarEstadoMesa(button) {
        const estadoActual = button.data("estado");

        // Alternamos entre "disponible" y "reservada"
        const nuevoEstado = estadoActual === 'disponible' ? 'reservada' : 'disponible';

        // Actualizamos el atributo "data-estado" del botón con el nuevo estado
        button.data("estado", nuevoEstado);

        // Establecemos el color del botón según el nuevo estado
        asignarColor(button, nuevoEstado);

        // Obtenemos el número de la mesa
        const mesaNum = button.data("numMesa");

        // Enviamos la solicitud AJAX para actualizar el estado en la base de datos
        $.ajax({
            url: "svMesaMod", // URL del servlet que manejará la actualización
            type: "POST",
            data: {
                mesaNum: mesaNum,  // El número de la mesa
                estado: nuevoEstado // El nuevo estado de la mesa
            },
            success: function(response) {
                console.log("Estado actualizado correctamente");
            },
            error: function(xhr, status, error) {
                console.error("Error al actualizar el estado de la mesa");
            }
        });
    }
</script>
</body>
</html>