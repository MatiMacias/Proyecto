<%-- 
    Document   : mostrarReserva
    Created on : 09/11/2024, 11:37:15
    Author     : Brython
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lista de Reservas</h1>
        <%
            List<Reservas> listaReservas = (List) request.getSession().getAttribute("listaReservas");
            int cont = 1;
            for(carrera carrera : carList){
        %>
        <p>Id Reserva: <%=Reserva.getIdReserva() %></p>
        <p>Nombre: <%=Reserva.getNombre %></p>
        <p>Apellido: <%=Reserva.getApellido() %></p>
        <p>Telefono: <%=Reserva.getTelofono() %></p>
        <p>Fecha: <%=Reserva.getFecha() %></p>
        <p>Hora: <%=Reserva.getHora() %></p>
        <p>Mesa: <%=Reserva.getMesa() %></p>
        <ul>
            <%
                List<Mesa> mesList = Reserva.getMesas();
                for(Mesa mesa : mesList){
            %>
            <li>
                <%=Reserva.getMesas() %>
            </li>
            <% } %>
        </ul>
        <%
            cont =+ 1;
            }%>
            <h1>
                <a href="reserva.jsp">
                    Volver
                </a>
            </h1>
    </body>
</html>
