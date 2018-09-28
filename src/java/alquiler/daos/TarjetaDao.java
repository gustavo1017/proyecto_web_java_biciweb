/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquiler.daos;
import alquiler.entidades.Tarjeta;
import java.util.List;

/**
 *
 * @author THEBEST
 */
public interface TarjetaDao {
     public void create(Tarjeta tarjeta);
    
    public Tarjeta find(int id);
    public List<Tarjeta> findAll();
    
    public void update(Tarjeta tarjeta);
    
    public void delete(Tarjeta tarjeta);
}
