/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquiler.daos.impl;
import alquiler.entidades.Cliente;
import alquiler.daos.ClienteDao;
import alquiler.entidades.Bicicleta;
import alquiler.util.DbConection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author THEBEST
 */
public class ClienteDaoImplPst implements ClienteDao{
     private Connection cn=null;
    private PreparedStatement pst;
    private ResultSet rs;
    @Override
    public void create(Cliente cliente) {
        try{
            cn = DbConection.getInstance().getConnection();
            pst = cn.prepareStatement("insert into cliente (nombre_cliente,apellido_cliente,dni_cliente,nombre_usuario,clave_usuario,id_tarjeta)  values (?,?,?,?,?,?)");
           
            pst.setString(1,cliente.getNombre_cliente());
            pst.setString(2,cliente.getApellido_cliente());
            pst.setString(3,cliente.getDni_cliente());
            pst.setString(4,cliente.getNombre_usuario_cliente());
            pst.setString(5,cliente.getClave_usuario_cliente());
            pst.setInt(6,cliente.getId_tarjeta());
            int reg = pst.executeUpdate();
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
            pst = cn.prepareStatement("select * from cliente where id_cliente=?");
            pst.setInt(1,id);
            rs = pst.executeQuery();
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
            pst = cn.prepareStatement("select * from cliente");
            rs = pst.executeQuery();
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
            pst = cn.prepareStatement("update cliente set nombre_cliente=?, apellido_cliente=?, dni_cliente, nombre_usuario, clave_usuario,id_tarjeta  where id_cliente =?");
            int reg = pst.executeUpdate();
            pst.setString(1,cliente.getNombre_cliente());
            pst.setString(2,cliente.getApellido_cliente()); 
            pst.setString(3,cliente.getDni_cliente()); 
            pst.setString(4,cliente.getNombre_usuario_cliente());
            pst.setString(5,cliente.getClave_usuario_cliente());
            pst.setInt(6,cliente.getId_tarjeta());
             pst.setInt(7,cliente.getId_cliente());
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
            pst = cn.prepareStatement("delete from cliente where id_cliente=?");
            int reg = pst.executeUpdate();
              pst.setInt(1,cliente.getId_cliente());
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
    
    
    
    
    
}
