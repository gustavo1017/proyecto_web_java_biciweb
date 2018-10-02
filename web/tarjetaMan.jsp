<%@page import="alquiler.servicios.TarjetaService"%>
<%@page import="alquiler.daos.TarjetaDao"%>
<%@page import="alquiler.servicios.impl.TarjetaServiceImpl"%>
<%@page import="alquiler.servicios.AlquilerService"%>
<%@page import="alquiler.entidades.Tarjeta"%>
<%@page import="java.util.List"%>
<%
    HttpSession websesion = request.getSession();
    if(websesion.getAttribute("nombre")==null){
        response.sendRedirect("error.jsp");
    }

    String sNombre = (String)websesion.getAttribute("nombre");
    String sApellido = (String)websesion.getAttribute("apellido");
   // List<Distrito> milista = (List<Distrito>)websesion.getAttribute("lista");
   TarjetaService servicio = new TarjetaServiceImpl();
   List<Tarjeta> milista = servicio.listar();
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
          <title>Bienvenido  <%= sNombre %> <%= sApellido %>!!!!!!</title>
        <a href="tarjetaInsertar.jsp">Nueva Tarjeta</a>
        <table border="1">
            <tr>
                <th>id tarjeta</th>
                <th>numero tarjeta</th>
                <th>nombre tarjeta</th>
                <th>tipo tarjeta</th>
                <th>fecha tarjeta</th>
                <th>Eliminar</th>
                <th>Actualizar</th>
            </tr>
            <%for(Tarjeta t:milista){%>
            <tr>
                <td><%= t.getId_tarjeta() %></td>
                <td><%= t.getNumero_tarjeta() %></td>
                <td><%= t.getNombre_tarjeta() %></td>
                <td><%= t.getTipo_tarjeta() %></td>
                <td><%= t.getFecha_ven_tarjeta() %></td>
                <td><a href="tarjetaEliminar.jsp?disId=<%= t.getId_tarjeta() %>">X</a></td>
                <td><a href="tarjetaActualizar.jsp?disId=<%= t.getId_tarjeta() %>">A</a></td>
            </tr>
            <%}%>
        </table>
    </body>
</html>
