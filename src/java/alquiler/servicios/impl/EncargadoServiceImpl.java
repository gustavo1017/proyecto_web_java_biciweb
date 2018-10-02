/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquiler.servicios.impl;
import alquiler.daos.impl.DaoFactory;
import alquiler.daos.EncargadoDao;
import alquiler.entidades.Encargado;
import alquiler.util.Util;
import alquiler.servicios.EncargadoService;
import java.util.List;
/**
 *
 * @author GUSTAVO
 */
public class EncargadoServiceImpl implements EncargadoService {
     private EncargadoDao dao;
    public EncargadoServiceImpl() {
        //dao = new DistritoDaoImplStm();
        dao = DaoFactory.getInstance().getEncargadoDao(Util.opc);
    }
    @Override
    public void grabar(Encargado encargado) {
        dao.create(encargado);
    }

    @Override
    public Encargado buscar(int id) {
       return dao.find(id);
    }

    @Override
    public List<Encargado> listar() {
        return dao.findAll();
    }

    @Override
    public void actualizar(Encargado encargado) {
        dao.update(encargado);
    }

    @Override
    public void borrar(Encargado encargado) {
       dao.delete(encargado);
    }
    
}
