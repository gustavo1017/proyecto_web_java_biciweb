/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquiler.servicios;
import alquiler.entidades.Estacionamiento;
import java.util.List;

/**
 *
 * @author GUSTAVO
 */
public interface EstacionamientoService {
        public void grabar(Estacionamiento estacionamiento);
    
    public Estacionamiento buscar(int id);
    public List<Estacionamiento> listar();
    
    public void actualizar(Estacionamiento Estacionamiento);
    
    public void borrar(Estacionamiento Estacionamiento);
}
