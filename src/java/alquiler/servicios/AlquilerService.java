/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquiler.servicios;
import alquiler.entidades.Alquiler;
import java.util.List;

/**
 *
 * @author GUSTAVO
 */
public interface AlquilerService {
        public void grabar(Alquiler alquiler);
    
    public Alquiler buscar(int id_cliente,int id_bicicleta);
    public List<Alquiler> listar();
    
 
}
