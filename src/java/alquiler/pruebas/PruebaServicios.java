/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquiler.pruebas;

import alquiler.daos.EncargadoDao;
import alquiler.daos.impl.EncargadoDaoImplCst;
import alquiler.entidades.Cliente;
import alquiler.entidades.Encargado;
import alquiler.servicios.ClienteService;
import alquiler.servicios.EncargadoService;
import alquiler.servicios.impl.ClienteServiceImpl;
import alquiler.servicios.impl.EncargadoServiceImpl;

/**
 *
 * @author GUSTAVO
 */
public class PruebaServicios {
    public static void main(String[]args){
        
             Cliente enca = new Cliente("juan", "gomez", "78945612", "batman2000", "aaaaa", 1);
       ClienteService dao = new ClienteServiceImpl();
        dao.grabar(enca);
          for(Cliente en:dao.listar()){
            System.out.print(en.getId_cliente()+"\t");
              System.out.print(en.getDni_cliente());
            System.out.print(en.getNombre_usuario_cliente());
             System.out.println(en.getClave_usuario_cliente());
             
        }
        
        
    }
}
