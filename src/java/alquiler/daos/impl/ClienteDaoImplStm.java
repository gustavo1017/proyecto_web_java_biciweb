/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquiler.daos.impl;
import alquiler.daos.ClienteDao;
import alquiler.entidades.Bicicleta;
import alquiler.entidades.Cliente;
import alquiler.util.DbConection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author THEBEST
 */
public class ClienteDaoImplStm implements ClienteDao{
      private Connection cn=null;
    private Statement st;
    private ResultSet rs;
    @Override
    public void create(Cliente cliente) {
           try{
            cn = DbConection.getInstance().getConnection();
            st = cn.createStatement();
            int reg = st.executeUpdate("insert into cliente values ('" 
                    + cliente.getNombre_cliente() + "','" + cliente.getApellido_cliente()+ "','" + cliente.getDni_cliente()+ "','" + cliente.getNombre_usuario_cliente()+ "','" + cliente.getClave_usuario_cliente()+ "','" + cliente.getId_tarjeta()+ "')");
             
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
            st = cn.createStatement();
            rs = st.executeQuery("select * from cliente where id_cliente='"+id+"'");
            if(rs.next()){
                cliente = new Cliente( rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
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
            st = cn.createStatement();
            rs = st.executeQuery("select * from cliente");
            while(rs.next()){
                lista.add(new Cliente( rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7)));
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
            st = cn.createStatement();
            int reg = st.executeUpdate("update cliente set nombre_cliente='"+cliente.getNombre_cliente()+
                    "', apellido_cliente='"+cliente.getApellido_cliente()+
                    "', dni_cliente='"+cliente.getDni_cliente()+
                    "', nombre_usuario='"+cliente.getNombre_usuario_cliente()+
                    "', clave_usuario='"+cliente.getClave_usuario_cliente()+
                    "', id_tarjeta='"+cliente.getId_tarjeta()+
                    "' where id_cliente='"+cliente.getId_cliente()+"';");
             
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
            st = cn.createStatement();
            int reg = st.executeUpdate("delete from cliente where id_cliente='"+cliente.getId_cliente()+"'");
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
