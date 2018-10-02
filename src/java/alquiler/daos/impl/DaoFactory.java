/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquiler.daos.impl;
import alquiler.daos.impl.*;
import alquiler.daos.*;
import alquiler.entidades.*;
import alquiler.daos.*;
import static alquiler.util.Util.CST;
import static alquiler.util.Util.PST;
import static alquiler.util.Util.STM;

/**
 *
 * @author GUSTAVO
 */
public class DaoFactory {
    
    private DaoFactory() {
    }
    
    public static DaoFactory getInstance() {
        return DaoFactoryHolder.INSTANCE;
    }

    
    
    private static class DaoFactoryHolder {

        private static final DaoFactory INSTANCE = new DaoFactory();
     
    }
        public ClienteDao getClienteDao(int opc){
        switch(opc){
            case STM: return new ClienteDaoImplStm();
            case PST: return new ClienteDaoImplPst();
            case CST: return new ClienteDaoImplCst();
            default:return null;
        }
    }
            public AlquilerDao getAlquilerDao(int opc){
        switch(opc){
            case STM: return new AlquilerDaoImplStm();
            case PST: return new AlquilerDaoImplPst();
            case CST: return new AlquilerDaoImplCst();
            default:return null;
        }
    }
       public BicicletaDao getBicicletaDao(int opc){
        switch(opc){
            case STM: return new BicicletaDaoImplStm();
            case PST: return new BicicletaDaoImplPst();
            case CST: return new BicicletaDaoImplCst();
            default:return null;
        }
    }
       
        public EncargadoDao getEncargadoDao(int opc){
        switch(opc){
            case STM: return new EncargadoDaoImplStm();
            case PST: return new EncargadoDaoImplPst();
            case CST: return new EncargadoDaoImplCst();
            default:return null;
        }
    }
           public EstacionamientoDao getEstacionamientoDao(int opc){
        switch(opc){
            case STM: return new EstacionamientoDaoImplStm();
            case PST: return new EstacionamientoDaoImplPst();
            case CST: return new EstacionamientoDaoImplCst();
            default:return null;
        }
    }
           
                public TarjetaDao getTarjetaDao(int opc){
        switch(opc){
            case STM: return new TarjetaDaoImplStm();
            case PST: return new TarjetaDaoImplPst();
            case CST: return new TarjetaDaoImplCst();
            default:return null;
        }
    }
}
