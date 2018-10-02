<%@page import="alquiler.servicios.TarjetaService"%>
<%@page import="alquiler.servicios.impl.TarjetaServiceImpl"%>
<%@page import="alquiler.entidades.Tarjeta"%>
<%
    HttpSession websesion = request.getSession();
    if(websesion.getAttribute("nombre")==null){
        response.sendRedirect("error.jsp");
    }

    String sNombre = (String)websesion.getAttribute("nombre");
    String sApellido = (String)websesion.getAttribute("apellido");
    
    int disCodigo =Integer.parseInt(request.getParameter("disId"));
    
    TarjetaService servicio = new TarjetaServiceImpl();
    
    Tarjeta tarjeta = servicio.buscar(disCodigo);
    

%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bienvenido  <%= sNombre %> <%= sApellido %>!!!!!!</title>
    </head>
    <body>
        <h1>Crear Distrito!</h1>
        <form action="tarjetaController">
            id tarjeta<input name="txtId" value="<%= tarjeta.getId_tarjeta() %>" readonly="true" /><br/>
            Numero tarjeta<input name="txtNumero" value="<%= tarjeta.getNumero_tarjeta()  %>"/><br/>
            Nombre tarjeta:<input name="txtNombre" value="<%= tarjeta.getNombre_tarjeta()  %>"/><br/>
            Tipo tarjeta:<input name="txtTarjeta" value="<%= tarjeta.getTipo_tarjeta() %>"/><br/>
            Fecha de vencimiento:<input name="txtVencimiento" value="<%= tarjeta.getFecha_ven_tarjeta() %>"/><br/>
            <input type="hidden" name="accion" value="eliminar" />
            <input type="submit" value="Grabar"/>
        </form>
        <a href="tarjetaMan.jsp">volver</a>
    </body>
</html>