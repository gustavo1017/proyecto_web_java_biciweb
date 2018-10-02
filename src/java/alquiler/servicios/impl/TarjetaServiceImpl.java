/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquiler.servicios.impl;
import alquiler.daos.impl.DaoFactory;
import alquiler.daos.TarjetaDao;
import alquiler.entidades.Tarjeta;
import alquiler.servicios.TarjetaService;
import alquiler.util.Util;
import java.util.List;
/**
 *
 * @author GUSTAVO
 */
public class TarjetaServiceImpl implements TarjetaService{
     private TarjetaDao dao;
    public TarjetaServiceImpl() {
        //dao = new DistritoDaoImplStm();
        dao = DaoFactory.getInstance().getTarjetaDao(Util.opc);
    }
    @Override
    public void grabar(Tarjeta tarjeta) {
       dao.create(tarjeta);
    }

    @Override
    public Tarjeta buscar(int id) {
        return dao.find(id);
    }

    @Override
    public List<Tarjeta> listar() {
       return dao.findAll();
    }

    @Override
    public void actualizar(Tarjeta tarjeta) {
        dao.update(tarjeta);
    }

    @Override
    public void borrar(Tarjeta tarjeta) {
        dao.delete(tarjeta);
    }
    
}
