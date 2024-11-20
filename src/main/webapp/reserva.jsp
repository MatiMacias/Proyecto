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
    <section>
        <div id="reservasTabulator"></div>
    </section>
    
     <link href="https://unpkg.com/tabulator-tables@6.2.5/dist/css/tabulator.min.css" rel="stylesheet">
    <script type="text/javascript" src="https://unpkg.com/tabulator-tables@6.2.5/dist/js/tabulator.min.js"></script>
    <script src="js/jquery-3.7.1.min.js"></script>
    <script>
        
        const reservasTabulator = new Tabulator("#reservasTabulator",{
            ajaxURL: "svReserva", 
            ajaxConfig: "GET",
            layout: "fitColumns",
            placeholder:"no hay reservas",
            columns:[
                {title:"Nombre",field:"nombre"},
                {title:"Apellido",field:"apellido"},
                {title:"Telefono",field:"telefono"},
                {title:"Nombre",field:"mesas.numMesa"},
                {
                    title:"Fecha",
                    field:"fecha",
                    formatter: function (cell, formatterParams, onRendered) {
                const fechaOriginal = cell.getValue(); // Obtener la fecha original
                return formatearFecha(fechaOriginal); // Formatear la fecha antes de mostrarla
            }

                },
                {
                    title:"Hora",
                    field:"hora",
                    formatter: function (cell) {
                        const rawTime = cell.getValue(); // Obtener valor de hora
                        if (rawTime) {
                            const timeObj = new Date(rawTime); // Crear un objeto Date
                            return timeObj.toLocaleTimeString([], { hour: '2-digit', minute: '2-digit' }); // Formato HH:mm
                        } else {
                            return "Hora no disponible"; // Manejo de casos nulos o inválidos
                        }
                    }
                },
                {
                    title:"eliminar",
                    formatter: "buttonCross",
                    cellClick: function(e,cell){
                    const reserva = cell.getRow().getData(); // Obtén los datos de la fila
                    eliminarReserva(reserva);;
                }
                }
            ]
        });
        
        
        function formatearFecha(fecha) {
    // Si la fecha está vacía o es un valor no válido, retornar "Fecha inválida"
    if (!fecha || typeof fecha !== 'object' || !fecha.year) {
        console.error("Fecha inválida:", fecha);
        return "Fecha inválida";
    }

    // Crear el objeto Date usando los datos de la fecha
    const fechaObjeto = new Date(fecha.year, fecha.month, fecha.dayOfMonth); // Usar directamente el mes tal cual es.

    // Comprobar si la fecha es válida
    if (isNaN(fechaObjeto.getTime())) {
        console.error("Fecha inválida:", fecha);
        return "Fecha inválida";
    }

    // Usar toLocaleDateString para formatear la fecha en formato dd/mm/yyyy
    const fechaFormateada = fechaObjeto.toLocaleDateString('es-ES', {
        day: '2-digit',
        month: '2-digit',
        year: 'numeric',
    });

    return fechaFormateada;
}
        
        
        function eliminarReserva(reserva){
                    $.ajax({
               url: "svReservaElim", // URL del servlet
               type: "POST", // Método POST
               data: {
                   idReserva: reserva.idReserva // Usa el ID de la reserva
               },
               success: function () {
                   alert("Reserva eliminada correctamente");
                   reservasTabulator.replaceData(); // Recargar el Tabulator
               },
               error: function (xhr, status, error) {
                   console.error("Error al eliminar la reserva:", error);
                   alert("No se pudo eliminar la reserva. Inténtalo de nuevo.");
               }
           });
        }
        
        
        
        
        
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