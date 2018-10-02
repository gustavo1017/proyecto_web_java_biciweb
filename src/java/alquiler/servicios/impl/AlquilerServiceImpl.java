/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquiler.servicios.impl;
import alquiler.entidades.Alquiler;
import alquiler.daos.AlquilerDao;
import alquiler.daos.impl.DaoFactory;
import alquiler.servicios.AlquilerService;
import alquiler.util.Util;
import java.util.List;
/**
 *
 * @author GUSTAVO
 */
public class AlquilerServiceImpl implements AlquilerService {
 private AlquilerDao dao;
    public AlquilerServiceImpl() {
        //dao = new DistritoDaoImplStm();
        dao = DaoFactory.getInstance().getAlquilerDao(Util.opc);
    }
    @Override
    public void grabar(Alquiler alquiler) {
        dao.create(alquiler);
    }

    @Override
    public Alquiler buscar(int id_cliente, int id_bicicleta) {
      return  dao.find(id_cliente, id_bicicleta);
    }

    @Override
    public List<Alquiler> listar() {
       return dao.findAll();
    }

    
}
