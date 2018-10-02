/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquiler.servicios;
import alquiler.entidades.Bicicleta;
import java.util.List;

/**
 *
 * @author GUSTAVO
 */
public interface BicicletaService {
        public void grabar(Bicicleta bicicleta);
    
    public Bicicleta buscar(int id);
    public List<Bicicleta> listar();
    
    public void actualizar(Bicicleta bicicleta);
    
    public void borrar(Bicicleta bicicleta);
}
