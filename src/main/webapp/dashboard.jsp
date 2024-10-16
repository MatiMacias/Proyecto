<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Restaurante X </title>
    <!-- Custom CSS -->
    <link rel="stylesheet" href="style/dashboard-style.css">
    <!-- Tabulator para gestionar datos en tablas-->
    

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
  <section class="table-section">
      <div class="section-container">
        
        <section id="third-section">
          <div id="button-grid">
              <!-- Botones para cambiar entre listas/tickets -->
              <button class="grid-button" data-list-id="1">Lista 1</button>
              <button class="grid-button" data-list-id="2">Lista 2</button>
              <button class="grid-button" data-list-id="3">Lista 3</button>
          </div>
      </section>
      </div>

      <Section>
        <div id="tablaProductos"></div>
      </section>

      <section>
        <h3>TICKET</h3>
        <div id="ticket-section"></div>
        <button>Imprimir</button>
        <h3>Total: <span id="total-sum">$0</span></h3>
      </section>

    </section>
    

     <!-- Tabulator para gestionar datos en tablas-->
    <link href="https://unpkg.com/tabulator-tables@6.2.5/dist/css/tabulator.min.css" rel="stylesheet">
    <script type="text/javascript" src="https://unpkg.com/tabulator-tables@6.2.5/dist/js/tabulator.min.js"></script>
    <script src="js/dashboard.js"></script>
</body>
</html>