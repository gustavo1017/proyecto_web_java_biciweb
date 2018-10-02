/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquiler.pruebas;

import alquiler.daos.AlquilerDao;
import alquiler.daos.BicicletaDao;
import alquiler.daos.ClienteDao;
import alquiler.daos.EncargadoDao;
import alquiler.daos.EstacionamientoDao;
import alquiler.daos.TarjetaDao;
import alquiler.daos.impl.AlquilerDaoImplCst;
import alquiler.daos.impl.BicicletaDaoImplCst;
import alquiler.daos.impl.ClienteDaoImplCst;
import alquiler.daos.impl.EncargadoDaoImplCst;
import alquiler.daos.impl.EstacionamientoDaoImplCst;
import alquiler.daos.impl.EstacionamientoDaoImplPst;
import alquiler.daos.impl.TarjetaDaoImplCst;
import alquiler.entidades.Alquiler;
import alquiler.entidades.Bicicleta;
import alquiler.entidades.Cliente;
import alquiler.entidades.Encargado;
import alquiler.entidades.Estacionamiento;
import alquiler.entidades.Tarjeta;

/**
 *
 * @author THEBEST
 */
public class PruebaCallableStatement {
    public static void main(String []args){
          Tarjeta enca = new Tarjeta("78945612","visa","aaaaa","170205");
       TarjetaDao dao = new TarjetaDaoImplCst();
        dao.create(enca);
          for(Tarjeta en:dao.findAll()){
            System.out.print(en.getId_tarjeta()+"\t");
              System.out.print(en.getNumero_tarjeta());
            System.out.print(en.getTipo_tarjeta());
             System.out.println(en.getFecha_ven_tarjeta());
             
        }
        
        
        
    }
}
