/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquiler.daos;
import alquiler.entidades.Encargado;
import java.util.List;

/**
 *
 * @author THEBEST
 */
public interface EncargadoDao {
     public void create(Encargado encargado);
    
    public Encargado find(int id);
    public List<Encargado> findAll();
    
    public void update(Encargado encargado);
    
    public void delete(Encargado encargado);
}
