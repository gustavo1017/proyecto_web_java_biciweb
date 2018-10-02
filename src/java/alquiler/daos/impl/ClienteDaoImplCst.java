/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquiler.daos.impl;
import alquiler.daos.ClienteDao;
import alquiler.entidades.Cliente;
import alquiler.util.DbConection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author GUSTAVO
 */
public class ClienteDaoImplCst implements ClienteDao{
 private Connection cn=null;
    private CallableStatement cst;
    private ResultSet rs;
    @Override
    public void create(Cliente cliente) {
         try{
            cn = DbConection.getInstance().getConnection();
            cst = cn.prepareCall("{call sp_insertar_cliente(?,?,?,?,?,?)}");
             cst.setString(1,cliente.getNombre_cliente());
            cst.setString(2,cliente.getApellido_cliente());
            cst.setString(3,cliente.getDni_cliente());
            cst.setString(4,cliente.getNombre_usuario_cliente());
            cst.setString(5,cliente.getClave_usuario_cliente());
            cst.setInt(6,cliente.getId_tarjeta());
            int reg = cst.executeUpdate();
            System.out.println(" Registros insertado: " + reg);
            cn.close();
        }catch(SQLException ex){
            System.out.println("codigo : "+ex.getErrorCode());
            System.out.println("mensaje : "+ex.getMessage());
            System.out.println("estado : "+ex.getSQLState());
            try {
                cn.close();
                System.out.println("conexion cerrada en el catch");
            } catch (SQLException ex1) {
                System.out.println("No se pudo cerrar la conexion");
            }
        }
    }

    @Override
    public Cliente find(int id) {
             Cliente cliente= null;
        try{
            cn = DbConection.getInstance().getConnection();
            cst = cn.prepareCall("{call sp_buscar_cliente(?)}");
            cst.setInt(1,id);
            rs = cst.executeQuery();
            if(rs.next()){
                cliente = new Cliente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
            }
            cn.close();
        }catch(SQLException ex){
            System.out.println("codigo : "+ex.getErrorCode());
            System.out.println("mensaje : "+ex.getMessage());
            System.out.println("estado : "+ex.getSQLState());
            try {
                cn.close();
                System.out.println("conexion cerrada en el catch");
            } catch (SQLException ex1) {
                System.out.println("No se pudo cerrar la conexion");
            }
        }
        return cliente;
    }

    @Override
    public List<Cliente> findAll() {
            List<Cliente> lista=new ArrayList<>();
        try{
            cn = DbConection.getInstance().getConnection();
            cst = cn.prepareCall("{call sp_listar_cliente()}");
            rs = cst.executeQuery();
            while(rs.next()){
                lista.add(new Cliente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7)));
            }
            cn.close();
        }catch(SQLException ex){
            System.out.println("codigo : "+ex.getErrorCode());
            System.out.println("mensaje : "+ex.getMessage());
            System.out.println("estado : "+ex.getSQLState());
            try {
                cn.close();
                System.out.println("conexion cerrada en el catch");
            } catch (SQLException ex1) {
                System.out.println("No se pudo cerrar la conexion");
            }
        }
        return lista;
    }

    @Override
    public void update(Cliente cliente) {
         try{
            cn = DbConection.getInstance().getConnection();
            cst = cn.prepareCall("{call sp_actualizar_cliente(?,?,?,?,?,?,?)}");
            
                 cst.setString(2,cliente.getNombre_cliente());
            cst.setString(3,cliente.getApellido_cliente()); 
            cst.setString(4,cliente.getDni_cliente()); 
            cst.setString(5,cliente.getNombre_usuario_cliente());
            cst.setString(6,cliente.getClave_usuario_cliente());
            cst.setInt(7,cliente.getId_tarjeta());
             cst.setInt(1,cliente.getId_cliente());
            int reg = cst.executeUpdate();
            System.out.println(" Registros actualizado: " + reg);
            cn.close();
        }catch(SQLException ex){
            System.out.println("codigo : "+ex.getErrorCode());
            System.out.println("mensaje : "+ex.getMessage());
            System.out.println("estado : "+ex.getSQLState());
            try {
                cn.close();
                System.out.println("conexion cerrada en el catch");
            } catch (SQLException ex1) {
                System.out.println("No se pudo cerrar la conexion");
            }
        }
    }

    @Override
    public void delete(Cliente cliente) {
            try{
            cn = DbConection.getInstance().getConnection();
            cst = cn.prepareCall("{call sp_eliminar_cliente(?)}");
            cst.setInt(1,cliente.getId_cliente());
            int reg = cst.executeUpdate();
              
            System.out.println(" Registros eliminado: " + reg);
            cn.close();
        }catch(SQLException ex){
            System.out.println("codigo : "+ex.getErrorCode());
            System.out.println("mensaje : "+ex.getMessage());
            System.out.println("estado : "+ex.getSQLState());
            try {
                cn.close();
                System.out.println("conexion cerrada en el catch");
            } catch (SQLException ex1) {
                System.out.println("No se pudo cerrar la conexion");
            }
        }
    }
    @Override
    public Cliente validar(String us, String ps) {
           Cliente cliente= null;
        try{
            cn = DbConection.getInstance().getConnection();
            cst = cn.prepareCall("{call sp_validar_cliente(?,?)}");
            cst.setString(1,us);
            cst.setString(2,ps);
            rs = cst.executeQuery();
            if(rs.next()){
                cliente = new Cliente(rs.getInt(1),
                                        rs.getString(2),
                                        rs.getString(3),
                                        rs.getString(4),
                                        rs.getString(5),
                                        rs.getString(6),
                                        rs.getInt(7));
                                      
            }
            cn.close();
        }catch(SQLException ex){
            System.out.println("codigo : "+ex.getErrorCode());
            System.out.println("mensaje : "+ex.getMessage());
            System.out.println("estado : "+ex.getSQLState());
            try {
                cn.close();
                System.out.println("conexion cerrada en el catch");
            } catch (SQLException ex1) {
                System.out.println("No se pudo cerrar la conexion");
            }
        }
        return cliente;
    }
  
    
}
