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
        <form>
            <div class="datos">
                <input type="text" id="nom" name="nom" placeholder="Nombre">
            </div>
            <div class="datos">
                <input type="text" id="ape" name="ape" placeholder="Apellido">
            </div>
            <div class="datos">
                <input type="tel" id="tel" name="tele" placeholder="Telefono: 3444570000">
            </div>
            <div class="datos">
                <input type="date" name="fecres" id="fecres">
            </div>
            <div class="datos">
                <input type="time" name="horares" id="horares">
            </div>
            <div class="datos">
                <input type="number" id="comen" name="comen" placeholder="Comensales" min="1" max="6">
            </div>
            <div class="datos">
                <select name="mesa" id="mesa">
                    <option value="" disabled selected>Mesa</option>
                    <option value="01">Mesa 1</option>
                    <option value="02">Mesa 2</option>
                    <option value="03">Mesa 3</option>
                    <option value="04">Mesa 4</option>
                    <option value="05">Mesa 5</option>
                    <option value="06">Mesa 6</option>
                    <option value="07">Mesa 7</option>
                    <option value="08">Mesa 8</option>
                    <option value="09">Mesa 9</option>
                    <option value="10">Mesa 10</option>
                    <option value="11">Mesa 11</option>
                    <option value="12">Mesa 12</option>
                    <option value="13">Mesa 13</option>
                    <option value="14">Mesa 14</option>
                    <option value="15">Mesa 15</option>
                    <option value="16">Mesa 16</option>
                    <option value="17">Mesa 17</option>
                    <option value="18">Mesa 18</option>
                    <option value="19">Mesa 19</option>
                    <option value="20">Mesa 20</option>
                </select>
            </div>
            <div class="datos">
                <input class="checkbox" type="checkbox" name="promo" id="promo" style="margin-left:5% ;">
                <label for="promo" id="prom">Enviarme promos<br> y anuncios</label>
            </div>
            <div class="datos">
                <button>Reservar Mesa</button>
            </div>
        </form>