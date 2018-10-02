/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquiler.servicios.impl;
import alquiler.daos.BicicletaDao;
import alquiler.daos.ClienteDao;
import alquiler.entidades.Bicicleta;
import alquiler.servicios.BicicletaService;
import alquiler.daos.impl.DaoFactory;
import java.util.List;
import alquiler.util.Util;
/**
 *
 * @author GUSTAVO
 */
public class BicicletaServiceImpl implements BicicletaService {
     private BicicletaDao dao;
    public BicicletaServiceImpl() {
        //dao = new DistritoDaoImplStm();
        dao =  DaoFactory.getInstance().getBicicletaDao(Util.opc);
    }
    
    
    @Override
    public void grabar(Bicicleta bicicleta) {
        dao.create(bicicleta);
    }

    @Override
    public Bicicleta buscar(int id) {
        return dao.find(id);
    }

    @Override
    public List<Bicicleta> listar() {
        return dao.findAll();
    }

    @Override
    public void actualizar(Bicicleta bicicleta) {
         dao.update(bicicleta);
    }

    @Override
    public void borrar(Bicicleta bicicleta) {
       dao.delete(bicicleta);
    }
    
}
