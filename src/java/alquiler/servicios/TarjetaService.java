/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquiler.servicios;
import alquiler.entidades.Tarjeta;
import java.util.List;
/**
 *
 * @author GUSTAVO
 */
public interface TarjetaService {
       public void grabar(Tarjeta tarjeta);
    
    public Tarjeta buscar(int id);
    public List<Tarjeta> listar();
    
    public void actualizar(Tarjeta tarjeta);
    
    public void borrar(Tarjeta tarjeta);
}
