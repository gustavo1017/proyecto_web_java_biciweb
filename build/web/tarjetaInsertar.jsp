<%@page import="alquiler.entidades.Tarjeta"%>
<%
    HttpSession websesion = request.getSession();
    if(websesion.getAttribute("nombre")==null){
        response.sendRedirect("error.jsp");
    }

    String sNombre = (String)websesion.getAttribute("nombre");
    String sApellido = (String)websesion.getAttribute("apellido");

%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bienvenido  <%= sNombre %> <%= sApellido %>!!!!!!</title>
    </head>
    <body>
        <h1>Crear Tarjeta!</h1>
        <form action="tarjetaController">
           <input name="txtId" value="1" style="visibility:hidden" /><br/>
            Numero tarjeta<input name="txtNumero"/><br/>
            Nombre tarjeta:<input name="txtNombre"/><br/>
            Tipo tarjeta:<input name="txtTarjeta"/><br/>
            Fecha de vencimiento:<input name="txtVencimiento"/><br/>
            <input type="hidden" name="accion" value="insertar"/>
            <input type="submit" value="Grabar"/>
        </form>
        <a href="tarjetaMan.jsp">volver</a>
    </body>
</html>
