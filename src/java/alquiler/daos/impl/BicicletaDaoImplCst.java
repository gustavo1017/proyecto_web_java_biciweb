/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquiler.daos.impl;
import alquiler.daos.BicicletaDao;
import alquiler.entidades.Bicicleta;
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
public class BicicletaDaoImplCst implements BicicletaDao{
      private Connection cn=null;
    private CallableStatement cst;
    private ResultSet rs;
    @Override
    public void create(Bicicleta bicicleta) {
          try{
            cn = DbConection.getInstance().getConnection();
            cst = cn.prepareCall("{call sp_insertar_bicicleta(?,?)}");
            cst.setString(1,bicicleta.getEstado_bicicleta());
            cst.setInt(2,bicicleta.getId_estacionamiento());
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
    public Bicicleta find(int id) {
               Bicicleta bicicleta= null;
        try{
            cn = DbConection.getInstance().getConnection();
            cst = cn.prepareCall("{call sp_buscar_bicicleta(?)}");
            cst.setInt(1,id);
            rs = cst.executeQuery();
            if(rs.next()){
                bicicleta = new Bicicleta(rs.getInt(1), rs.getString(2), rs.getInt(3));
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
        return bicicleta;
    }

    @Override
    public List<Bicicleta> findAll() {
                List<Bicicleta> lista=new ArrayList<>();
        try{
            cn = DbConection.getInstance().getConnection();
            cst = cn.prepareCall("{call sp_listar_bicicleta()}");
            rs = cst.executeQuery();
            while(rs.next()){
                lista.add(new Bicicleta(rs.getInt(1), rs.getString(2), rs.getInt(3)));
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
    public void update(Bicicleta bicicleta) {
          try{
            cn = DbConection.getInstance().getConnection();
            cst = cn.prepareCall("{call sp_actualizar_bicicleta(?,?,?)}");
            cst.setInt(1,bicicleta.getId_bicicleta());
            cst.setString(2,bicicleta.getEstado_bicicleta());
            cst.setInt(3,bicicleta.getId_estacionamiento()); 
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
    public void delete(Bicicleta bicicleta) {
              try{
            cn = DbConection.getInstance().getConnection();
            cst = cn.prepareCall("{call sp_eliminar_bicicleta(?)}");
            cst.setInt(1,bicicleta.getId_bicicleta());
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
