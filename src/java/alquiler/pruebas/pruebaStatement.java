/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquiler.pruebas;
import alquiler.daos.EncargadoDao;
import alquiler.daos.EstacionamientoDao;
import alquiler.entidades.Encargado;
import alquiler.daos.impl.EncargadoDaoImplStm;
import alquiler.daos.impl.EstacionamientoDaoImplStm;
import alquiler.entidades.Estacionamiento;
/**
 *
 * @author THEBEST
 */
public class pruebaStatement {
    public static void main(String []args){
        
      /*  EncargadoDao objeto = new EncargadoDaoImplStm();
        
        Encargado en = new Encargado(6,"julio","suarez","999560123","siempre viva 123");
        
        objeto.delete(en);
        
         for(Encargado enc:objeto.findAll()){
            System.out.print(enc.getId_encargado()+"\t");
            System.out.print(enc.getNombre_encargado());
             System.out.print(enc.getTelefono_encargado());
              System.out.println(enc.getDireccion_encargado());
        } */
        Estacionamiento estacionamiento = new Estacionamiento("banco","av venezuela 7856",2);
        EstacionamientoDao dao = new EstacionamientoDaoImplStm();
        dao.create(estacionamiento);
          for(Estacionamiento estacion:dao.findAll()){
            System.out.print(estacion.getId_estacionamiento()+"\t");
            System.out.print(estacion.getNombre_estacionamiento());
             System.out.print(estacion.getDireccion_estacionamiento());
              System.out.println(estacion.getId_encargado());
        }
        
        
        
        
    }
}
