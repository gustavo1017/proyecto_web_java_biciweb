/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquiler.servicios.impl;
import alquiler.daos.impl.DaoFactory;
import alquiler.daos.EstacionamientoDao;
import alquiler.entidades.Estacionamiento;
import alquiler.servicios.EstacionamientoService;
import alquiler.util.Util;
import alquiler.servicios.EstacionamientoService;
import java.util.List;
/**
 *
 * @author GUSTAVO
 */
public class EstacionamientoServiceImpl implements EstacionamientoService{
     private EstacionamientoDao dao;
    public EstacionamientoServiceImpl() {
        //dao = new DistritoDaoImplStm();
        dao = DaoFactory.getInstance().getEstacionamientoDao(Util.opc);
    }
    @Override
    public void grabar(Estacionamiento estacionamiento) {
        dao.create(estacionamiento);
    }

    @Override
    public Estacionamiento buscar(int id) {
       return dao.find(id);
    }

    @Override
    public List<Estacionamiento> listar() {
       return dao.findAll();
    }

    @Override
    public void actualizar(Estacionamiento Estacionamiento) {
         dao.update(Estacionamiento);
    }

    @Override
    public void borrar(Estacionamiento Estacionamiento) {
        dao.delete(Estacionamiento);
    }
    
}
