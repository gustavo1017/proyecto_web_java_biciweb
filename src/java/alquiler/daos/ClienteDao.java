/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquiler.daos;
import alquiler.entidades.Cliente;
import java.util.List;

/**
 *
 * @author THEBEST
 */
public interface ClienteDao {
     public void create(Cliente cliente);
    
    public Cliente find(int id);
    public List<Cliente> findAll();
    
    public void update(Cliente cliente);
    
    public void delete(Cliente cliente);
     public Cliente validar(String us, String ps);
}
