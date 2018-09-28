/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquiler.daos;
import alquiler.entidades.Estacionamiento;
import java.util.List;

/**
 *
 * @author THEBEST
 */
public interface EstacionamientoDao {
    
    
     public void create(Estacionamiento estacionamiento);
    
    public Estacionamiento find(int id);
    public List<Estacionamiento> findAll();
    
    public void update(Estacionamiento estacionamiento);
    
    public void delete(Estacionamiento estacionamiento);
}
