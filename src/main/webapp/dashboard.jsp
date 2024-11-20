<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Restaurante X </title>
    <!-- Custom CSS -->
    <link rel="stylesheet" href="style/dashboard-style.css">
</head>

<body>
  <header>
    <nav id="accion">
      <div>
        <a href="#" id="logo">Nombre X</a>
      </div>
      <div id="herramientas">
        <ul class="menu">
          <li class="dropdown">
            <a class="dropbtn">Acciones</a>
              <div class="dropdown-content">
                <a href="carta.jsp">Carta</a>
                <a href="reserva.jsp">Reservas</a>
                <a href="mesas.jsp">Mesas</a>
              </div>
          </li>
          <li id="finalizar">
            <a href="index.jsp" class="dropbtn">Cerrar Sesión</a>
          </li>
        </ul>
      </div>
    </nav>
  </header>
   <section id="mesas-section">
        <h2>Mesas</h2>
        <div id="mesas-container">
            <!-- Aquí se generarán los botones de mesas -->
        </div>
    </section>

    <section id="productos-section">
        <h2>Productos</h2>
        <div id="productos-tabulator"></div>
    </section>

    <section id="ticket-section">
        <h2>Ticket</h2>
        <div id="ticket-info">
            <p><strong>Mesa:</strong> <span id="mesa-seleccionada">Ninguna</span></p>
            <div id="ticket-tabulator"></div>
            <p><strong>Total:</strong> $<span id="total-ticket">0.00</span></p>
        </div>
    </section>


     <!-- Tabulator para gestionar datos en tablas-->
    <link href="https://unpkg.com/tabulator-tables@6.2.5/dist/css/tabulator.min.css" rel="stylesheet">
    <script type="text/javascript" src="https://unpkg.com/tabulator-tables@6.2.5/dist/js/tabulator.min.js"></script>
    <script src="js/jquery-3.7.1.min.js"></script>
    
    <script src="js/dash.js"></script>
    
</body>
</html>