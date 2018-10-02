/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquiler.daos.impl;
import alquiler.daos.EncargadoDao;
import alquiler.entidades.Encargado;
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
public class EncargadoDaoImplCst implements EncargadoDao{
     private Connection cn=null;
    private CallableStatement cst;
    private ResultSet rs;
    @Override
    public void create(Encargado encargado) {
           try{
            cn = DbConection.getInstance().getConnection();
            cst = cn.prepareCall("{call sp_insertar_encargado(?,?,?,?)}");
              cst.setString(1,encargado.getNombre_encargado());
            cst.setString(2,encargado.getApellido_encargado());
            cst.setString(3,encargado.getTelefono_encargado());
            cst.setString(4,encargado.getDireccion_encargado());
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
    public Encargado find(int id) {
         Encargado encargado= null;
        try{
            cn = DbConection.getInstance().getConnection();
            cst = cn.prepareCall("{call sp_buscar_encargado(?)}");
            cst.setInt(1,id);
            rs = cst.executeQuery();
            if(rs.next()){
                encargado = new Encargado(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
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
        return encargado;
    }

    @Override
    public List<Encargado> findAll() {
          List<Encargado> lista=new ArrayList<>();
        try{
            cn = DbConection.getInstance().getConnection();
            cst = cn.prepareCall("{call sp_listar_encargado()}");
            rs = cst.executeQuery();
            while(rs.next()){
                lista.add(new Encargado(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
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
    public void update(Encargado encargado) {
           try{
            cn = DbConection.getInstance().getConnection();
            cst = cn.prepareCall("{call sp_actualizar_encargado(?,?,?,?,?)}");
            
             cst.setString(2,encargado.getNombre_encargado());
            cst.setString(3,encargado.getApellido_encargado()); 
            cst.setString(4,encargado.getTelefono_encargado()); 
            cst.setString(5,encargado.getDireccion_encargado());
             cst.setInt(1,encargado.getId_encargado());
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
    public void delete(Encargado encargado) {
               try{
            cn = DbConection.getInstance().getConnection();
            cst = cn.prepareCall("{call sp_eliminar_encargado(?)}");
            cst.setInt(1,encargado.getId_encargado());
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
