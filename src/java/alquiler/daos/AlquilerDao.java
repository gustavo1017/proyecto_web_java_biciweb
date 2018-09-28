/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquiler.daos;
import alquiler.entidades.Alquiler;
import java.util.List;

/**
 *
 * @author THEBEST
 */
public interface AlquilerDao {
    public void create(Alquiler alquiler);
    public Alquiler find(int id_cliente,int id_bicicleta );
    public List<Alquiler> findAll();
  
   
}
