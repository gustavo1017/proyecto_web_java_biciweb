/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquiler.daos.impl;
import alquiler.daos.EstacionamientoDao;
import alquiler.util.DbConection;
import alquiler.entidades.Estacionamiento;
import alquiler.entidades.Tarjeta;
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
public class EstacionamientoDaoImplPst  implements EstacionamientoDao{
       private Connection cn=null;
    private PreparedStatement pst;
    private ResultSet rs;
    @Override
    public void create(Estacionamiento estacionamiento) {
             try{
            cn = DbConection.getInstance().getConnection();
            pst = cn.prepareStatement("insert into estacionamiento (nombre_estacionamiento,direccion_estacionamiento,id_encargado)  values (?,?,?)");
           
            pst.setString(1,estacionamiento.getNombre_estacionamiento());
            pst.setString(2,estacionamiento.getDireccion_estacionamiento());
            pst.setInt(3,estacionamiento.getId_encargado());
          
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
    public Estacionamiento find(int id) {
                     Estacionamiento estacionamiento= null;
        try{
            cn = DbConection.getInstance().getConnection();
            pst = cn.prepareStatement("select * from estacionamiento where id_estacionamiento=?");
            pst.setInt(1,id);
            rs = pst.executeQuery();
            if(rs.next()){
                estacionamiento= new Estacionamiento(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
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
            pst = cn.prepareStatement("select * from estacionamiento");
            rs = pst.executeQuery();
            while(rs.next()){
                lista.add( new Estacionamiento(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
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
            pst = cn.prepareStatement("update estacionamiento set nombre_estacionamiento=?, direccion_estacionamiento=?, id_encargado=? where id_estacionamiento=?");
            int reg = pst.executeUpdate();
            pst.setString(1,estacionamiento.getNombre_estacionamiento());
            pst.setString(2,estacionamiento.getDireccion_estacionamiento()); 
            pst.setInt(3,estacionamiento.getId_encargado()); 
             pst.setInt(4,estacionamiento.getId_estacionamiento());
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
            pst = cn.prepareStatement("delete from estacionamiento where id_estacionamiento=?");
            int reg = pst.executeUpdate();
              pst.setInt(1,estacionamiento.getId_estacionamiento());
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
