<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Reservas</title>
        <!-- Custom CSS -->
        <link rel="stylesheet" href="style/reserva-style.css">
</head>

<body>
    <header class="encabezado">
        <nav>
            <div>
            <a href="#" id="logo">Nombre X</a>
            </div>
            <div class="regreso">
                <a href="dashboard.jsp" id="cierre"><button class="link">Volver</button></a>
            </div>
        </nav>
    </header>
    <section>
        <header>
            <h1>RESERVACIONES</h1>
        </header>
        <form action="svReserva" method="POST">
            <div class="datos">
                <input type="text" id="nom" name="nom" placeholder="Nombre">
            </div>
            <div class="datos">
                <input type="text" id="ape" name="ape" placeholder="Apellido">
            </div>
            <div class="datos">
                <input type="text" id="tel" name="tel" placeholder="Telefono: 3444570000">
            </div>
            <div class="datos">
                <input type="date" name="fecRes" id="fecres">
            </div>
            <div class="datos">
                <input type="time" name="horaRes" id="horares">
            </div>
            <div class="datos">
                <input type="number" id="comen" name="comen" placeholder="Comensales" min="1" max="6">
            </div>
            <div class="datos">
                <select name="mesa" id="mesa">
                    
                </select>
            </div>
            <div class="datos">
                <input class="checkbox" type="checkbox" name="promo" id="promo" style="margin-left:5% ;">
                <label for="promo" id="prom">Enviarme promos<br> y anuncios</label>
            </div>
            <div class="datos">
                <button type="submit">Reservar Mesa</button>
            </div>
        </form>
    </section>
    
    <script src="js/jquery-3.7.1.min.js"></script>
    <script>
            $(document).ready(function() {
    $.ajax({
        url: 'selectMesa', // URL del servlet
        type: 'GET',
        dataType: 'json', // Tipo de respuesta esperado
        success: function(data) {
            // Limpiar el <select>
            $("#mesa").empty();
            
            // Añadir una opción predeterminada
            $("#mesa").append('<option value="">Seleccione una mesa</option>');
            
            // Recorrer los nombres de las categorías y añadirlos al <select>
            data.forEach(function(numeroMesas) {
                $("#mesa").append(
                    '<option value="' + numeroMesas + '">' + numeroMesas + '</option>'
                );
            });
        },
        error: function(xhr, status, error) {
            console.error("Error al cargar las categorías: ", error);
        }
    });
});
    </script>
    
</body>
</html>