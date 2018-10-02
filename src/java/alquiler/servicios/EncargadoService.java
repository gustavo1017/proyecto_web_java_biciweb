/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquiler.servicios;
import alquiler.entidades.Encargado;
import java.util.List;

/**
 *
 * @author GUSTAVO
 */
public interface EncargadoService {
      public void grabar(Encargado encargado);
    
    public Encargado buscar(int id);
    public List<Encargado> listar();
    
    public void actualizar(Encargado encargado);
    
    public void borrar(Encargado encargado);
}
