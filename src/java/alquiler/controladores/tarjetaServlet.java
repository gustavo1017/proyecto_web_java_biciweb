/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquiler.controladores;

import alquiler.entidades.Tarjeta;
import alquiler.servicios.TarjetaService;
import alquiler.servicios.impl.TarjetaServiceImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author GUSTAVO
 */
@WebServlet(name = "tarjetaServlet", urlPatterns = {"/tarjetaController"})
public class tarjetaServlet extends HttpServlet {

 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("txtId"));
        String numero_tarjeta=request.getParameter("txtNumero");
        String nombre_tarjeta=request.getParameter("txtNombre");
        String tipo_tarjeta=request.getParameter("txtTarjeta");
        String fecha_tarjeta=request.getParameter("txtVencimiento");
        String accion=request.getParameter("accion");
        
        TarjetaService servicio = new TarjetaServiceImpl();
        
        switch(accion){
            case "insertar":{
                servicio.grabar(new Tarjeta( numero_tarjeta, nombre_tarjeta, tipo_tarjeta, fecha_tarjeta));
                break;
            }
            case "eliminar":{
                servicio.borrar(new Tarjeta( id ,numero_tarjeta, nombre_tarjeta, tipo_tarjeta,fecha_tarjeta));
                break;
            }
            case "actualizar":{
                servicio.actualizar(new Tarjeta( id ,numero_tarjeta, nombre_tarjeta, tipo_tarjeta,fecha_tarjeta));
                break;
            }
            default:{
                
            }
        }
        response.sendRedirect("tarjetaMan.jsp");
        
        
        
        
        
        
        
       
    }

   

}
