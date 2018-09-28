/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquiler.daos.impl;
import alquiler.util.DbConection;
import alquiler.daos.EstacionamientoDao;
import alquiler.entidades.Bicicleta;
import alquiler.entidades.Cliente;
import alquiler.entidades.Encargado;
import alquiler.entidades.Estacionamiento;
import alquiler.entidades.Tarjeta;
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
public class EstacionamientoDaoImplStm implements EstacionamientoDao{
    private Connection cn=null;
    private Statement st;
    private ResultSet rs;

    @Override
    public void create(Estacionamiento estacionamiento) {
           try{
            cn = DbConection.getInstance().getConnection();
            st = cn.createStatement();
            int reg = st.executeUpdate("insert into estacionamiento (nombre_estacionamiento,direccion_estacionamiento,id_encargado) values ('" 
                    + estacionamiento.getNombre_estacionamiento() + "','"+estacionamiento.getDireccion_estacionamiento()+ "','"+ estacionamiento.getId_encargado() +  "')");
             
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
    public Estacionamiento find(int id) {
           Estacionamiento estacionamiento= null;
        try{
            cn = DbConection.getInstance().getConnection();
            st = cn.createStatement();
            rs = st.executeQuery("select * from estacionamiento where id_estacionamiento='"+id+"'");
            if(rs.next()){
                estacionamiento = new Estacionamiento(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
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
        return estacionamiento;
    }

    @Override
    public List<Estacionamiento> findAll() {
                   List<Estacionamiento> lista=new ArrayList<>();
        try{
            cn = DbConection.getInstance().getConnection();
            st = cn.createStatement();
            rs = st.executeQuery("select * from estacionamiento");
            while(rs.next()){
                lista.add(new Estacionamiento(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
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
    public void update(Estacionamiento estacionamiento) {
         try{
            cn = DbConection.getInstance().getConnection();
            st = cn.createStatement();
            int reg = st.executeUpdate("update estacionamiento set nombre_estacionamiento='"+estacionamiento.getNombre_estacionamiento()+
                    "', direccion_estacionamiento='"+estacionamiento.getDireccion_estacionamiento()+
                     "', id_encargado='"+estacionamiento.getId_encargado()+
                    
                    "' where id_estacionamiento='"+estacionamiento.getId_estacionamiento()+"';");
             
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
    public void delete(Estacionamiento estacionamiento) {
        try{
            cn = DbConection.getInstance().getConnection();
            st = cn.createStatement();
            int reg = st.executeUpdate("delete from estacionamiento where id_estacionamiento='"+estacionamiento.getId_estacionamiento()+"'");
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
