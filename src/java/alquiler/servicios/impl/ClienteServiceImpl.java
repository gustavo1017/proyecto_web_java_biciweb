/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquiler.servicios.impl;
import alquiler.daos.impl.DaoFactory;
import alquiler.entidades.Cliente;
import alquiler.daos.ClienteDao;
import alquiler.servicios.ClienteService;
import alquiler.util.Util;
import java.util.List;
/**
 *
 * @author GUSTAVO
 */
public class ClienteServiceImpl implements ClienteService {
   private ClienteDao dao;
    public ClienteServiceImpl() {
        //dao = new DistritoDaoImplStm();
        dao = DaoFactory.getInstance().getClienteDao(Util.opc);
    }
    @Override
    public void grabar(Cliente cliente) {
        dao.create(cliente);
    }

    @Override
    public Cliente buscar(int id) {
        return dao.find(id);
    }

    @Override
    public List<Cliente> listar() {
        return dao.findAll();
    }

    @Override
    public void actualizar(Cliente cliente) {
        dao.update(cliente);
    }

    @Override
    public void borrar(Cliente cliente) {
       dao.delete(cliente);
    }

    @Override
    public Cliente ingresar(String usu, String pas) {
        return dao.validar(usu, pas);
    }
 
    
    
    
}
