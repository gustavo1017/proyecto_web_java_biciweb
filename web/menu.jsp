<%@page import="alquiler.entidades.Cliente"%>
<%@page import="java.util.List"%>
<%
    HttpSession websesion = request.getSession();
    if(websesion.getAttribute("nombre")==null){
        response.sendRedirect("error.jsp");
    }

    String sNombre = (String)websesion.getAttribute("nombre");
    String sApellido = (String)websesion.getAttribute("apellido");
    List<Cliente> milista = (List<Cliente>)websesion.getAttribute("lista");

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
   
        <h1>Bienvenido  <%= sNombre %> <%= sApellido %>!!!!!!</h1>
        <a href="tarjetaMan.jsp">Mantenimiento de Tarjetas</a>
    </body>
</html>
