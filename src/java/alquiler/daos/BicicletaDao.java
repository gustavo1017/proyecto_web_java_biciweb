/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquiler.daos;
import alquiler.entidades.Bicicleta;
import java.util.List;

/**
 *
 * @author THEBEST
 */
public interface BicicletaDao {
     public void create(Bicicleta bicicleta);
    
    public Bicicleta find(int id);
    public List<Bicicleta> findAll();
    
    public void update(Bicicleta bicicleta);
    
    public void delete(Bicicleta bicicleta);
    
    
    
}
