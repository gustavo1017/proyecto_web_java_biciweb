/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquiler.controladores;

import alquiler.entidades.Encargado;
import alquiler.servicios.EncargadoService;
import alquiler.servicios.impl.EncargadoServiceImpl;
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
@WebServlet(name = "EncargadoServlet", urlPatterns = {"/Encargado"})
public class EncargadoServlet extends HttpServlet {

   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String nombre=request.getParameter("txtNombre");
        String apellido=request.getParameter("txtApellido");
        String telefono=request.getParameter("txtTelefono");
        String direccion=request.getParameter("txtDireccion");
        String accion=request.getParameter("accion");
        
        EncargadoService servicio = new EncargadoServiceImpl();
        
        switch(accion){
            case "insertar":{
                servicio.grabar(new Encargado(nombre,apellido,telefono,direccion));
                break;
            }
            case "eliminar":{
                servicio.borrar(new Encargado(nombre,apellido,telefono,direccion));
                break;
            }
            case "actualizar":{
                servicio.actualizar(new Encargado(nombre,apellido,telefono,direccion));
                break;
            }
            default:{
                
            }
        }
        response.sendRedirect("Encargado.jsp");
        
       
    }

    



}
