/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquiler.daos.impl;
import alquiler.daos.EstacionamientoDao;
import alquiler.entidades.Estacionamiento;
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
public class EstacionamientoDaoImplCst implements EstacionamientoDao{
      private Connection cn=null;
    private CallableStatement cst;
    private ResultSet rs;
    @Override
    public void create(Estacionamiento estacionamiento) {
          try{
            cn = DbConection.getInstance().getConnection();
            cst = cn.prepareCall("{call sp_insertar_estacionamiento(?,?,?)}");
             cst.setString(1,estacionamiento.getNombre_estacionamiento());
            cst.setString(2,estacionamiento.getDireccion_estacionamiento());
            cst.setInt(3,estacionamiento.getId_encargado());
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
    public Estacionamiento find(int id) {
          Estacionamiento estacionamiento= null;
        try{
            cn = DbConection.getInstance().getConnection();
            cst = cn.prepareCall("{call sp_buscar_estacionamiento(?)}");
            cst.setInt(1,id);
            rs = cst.executeQuery();
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
            cst = cn.prepareCall("{call sp_listar_estacionamiento()}");
            rs = cst.executeQuery();
            while(rs.next()){
                lista.add(new Estacionamiento(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)) );
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
            cst = cn.prepareCall("{call sp_actualizar_estacionamiento(?,?,?,?)}");
            
            cst.setString(2,estacionamiento.getNombre_estacionamiento());
            cst.setString(3,estacionamiento.getDireccion_estacionamiento()); 
            cst.setInt(4,estacionamiento.getId_encargado()); 
             cst.setInt(1,estacionamiento.getId_estacionamiento());
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
    public void delete(Estacionamiento estacionamiento) {
             try{
            cn = DbConection.getInstance().getConnection();
            cst = cn.prepareCall("{call sp_eliminar_estacionamiento(?)}");
            cst.setInt(1,estacionamiento.getId_estacionamiento());
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
    
}
