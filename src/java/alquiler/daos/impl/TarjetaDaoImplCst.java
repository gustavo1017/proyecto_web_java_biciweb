/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquiler.daos.impl;
import alquiler.daos.TarjetaDao;
import alquiler.entidades.Tarjeta;
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
public class TarjetaDaoImplCst implements TarjetaDao{
     private Connection cn=null;
    private CallableStatement cst;
    private ResultSet rs;
    @Override
    public void create(Tarjeta tarjeta) {
            try{
            cn = DbConection.getInstance().getConnection();
            cst = cn.prepareCall("{call sp_insertar_tarjeta(?,?,?,?)}");
             cst.setString(1,tarjeta.getNumero_tarjeta());
            cst.setString(2,tarjeta.getNombre_tarjeta());
            cst.setString(3,tarjeta.getTipo_tarjeta());
            cst.setString(4,tarjeta.getFecha_ven_tarjeta());
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
    public Tarjeta find(int id) {
           Tarjeta tarjeta= null;
        try{
            cn = DbConection.getInstance().getConnection();
            cst = cn.prepareCall("{call sp_buscar_tarjeta(?)}");
            cst.setInt(1,id);
            rs = cst.executeQuery();
            if(rs.next()){
                tarjeta = new Tarjeta(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
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
        return tarjeta;
    }

    @Override
    public List<Tarjeta> findAll() {
           List<Tarjeta> lista=new ArrayList<>();
        try{
            cn = DbConection.getInstance().getConnection();
            cst = cn.prepareCall("{call sp_listar_tarjeta()}");
            rs = cst.executeQuery();
            while(rs.next()){
                lista.add(new Tarjeta(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
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
    public void update(Tarjeta tarjeta) {
         try{
            cn = DbConection.getInstance().getConnection();
            cst = cn.prepareCall("{call sp_actualizar_tarjeta(?,?,?,?,?)}");
            cst.setInt(1,tarjeta.getId_tarjeta());
          cst.setString(2,tarjeta.getNumero_tarjeta());
            cst.setString(3,tarjeta.getNombre_tarjeta()); 
            cst.setString(4,tarjeta.getTipo_tarjeta()); 
            cst.setString(5,tarjeta.getFecha_ven_tarjeta());
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
    public void delete(Tarjeta tarjeta) {
           try{
            cn = DbConection.getInstance().getConnection();
            cst = cn.prepareCall("{call sp_eliminar_tarjeta(?)}");
            cst.setInt(1,tarjeta.getId_tarjeta());
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
