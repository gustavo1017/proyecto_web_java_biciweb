/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquiler.servicios;
import alquiler.entidades.Cliente;
import java.util.List;

/**
 *
 * @author GUSTAVO
 */
public interface ClienteService {
       public void grabar(Cliente cliente);
    
    public Cliente buscar(int id);
    public List<Cliente> listar();
    
    public void actualizar(Cliente cliente);
    
    public void borrar(Cliente cliente);
      public Cliente ingresar(String usu, String pas);
}
