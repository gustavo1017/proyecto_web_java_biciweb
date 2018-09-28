/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquiler.pruebas;

import alquiler.daos.EstacionamientoDao;
import alquiler.daos.impl.EstacionamientoDaoImplPst;
import alquiler.daos.impl.EstacionamientoDaoImplStm;
import alquiler.entidades.Estacionamiento;

/**
 *
 * @author THEBEST
 */
public class PruebaPreparedStatement {
    public static void main(String [] args){
          Estacionamiento estacionamiento = new Estacionamiento("El paradero","av real 4567",3);
        EstacionamientoDao dao = new EstacionamientoDaoImplPst();
        dao.create(estacionamiento);
          for(Estacionamiento estacion:dao.findAll()){
            System.out.print(estacion.getId_estacionamiento()+"\t");
            System.out.print(estacion.getNombre_estacionamiento());
             System.out.print(estacion.getDireccion_estacionamiento());
              System.out.println(estacion.getId_encargado());
        }
        
        
        
        
        
        
    }
}
