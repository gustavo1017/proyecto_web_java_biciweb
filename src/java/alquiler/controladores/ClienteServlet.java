/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquiler.controladores;

import alquiler.entidades.Cliente;
import alquiler.servicios.ClienteService;
import alquiler.servicios.impl.ClienteServiceImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author GUSTAVO
 */
@WebServlet(name = "ClienteServlet", urlPatterns = {"/clienteController"})
public class ClienteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String sUsuario = request.getParameter("txtUsuario");
        String sPassword =request.getParameter("txtPassword");
        
        ClienteService servicio = new ClienteServiceImpl();
        Cliente cliente = servicio.ingresar(sUsuario, sPassword);
        
      
        
        HttpSession sesion = request.getSession();
        
        if(cliente!=null){
            sesion.setAttribute("nombre",cliente.getNombre_cliente());
            sesion.setAttribute("apellido",cliente.getApellido_cliente());
            sesion.setAttribute("lista", servicio.listar());
             response.sendRedirect("menu.jsp");
        }else{
            response.sendRedirect("error.jsp");
        }
           
       
        
        
        
    }

   
  

}
