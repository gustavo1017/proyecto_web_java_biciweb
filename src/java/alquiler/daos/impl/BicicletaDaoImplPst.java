/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquiler.daos.impl;
import alquiler.entidades.Bicicleta;
import alquiler.daos.BicicletaDao;
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
public class BicicletaDaoImplPst implements BicicletaDao {
    
     private Connection cn=null;
    private PreparedStatement pst;
    private ResultSet rs;
    @Override
    public void create(Bicicleta bicicleta) {
            try{
            cn = DbConection.getInstance().getConnection();
            pst = cn.prepareStatement("insert into bicicleta (estado_bicicleta,id_estacionamiento)  values (?,?)");
           
            pst.setString(1,bicicleta.getEstado_bicicleta());
            pst.setInt(2,bicicleta.getId_estacionamiento());
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
    public Bicicleta find(int id) {
         Bicicleta bicicleta= null;
        try{
            cn = DbConection.getInstance().getConnection();
            pst = cn.prepareStatement("select * from bicicleta where id_bicicleta=?");
            pst.setInt(1,id);
            rs = pst.executeQuery();
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
            pst = cn.prepareStatement("select * from bicicleta");
            rs = pst.executeQuery();
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
            pst = cn.prepareStatement("update bicicleta set estado_bicicleta=?, id_estacionamiento=? where id_bicicleta=?");
            int reg = pst.executeUpdate();
            pst.setInt(3,bicicleta.getId_bicicleta());
            pst.setString(1,bicicleta.getEstado_bicicleta());
            pst.setInt(2,bicicleta.getId_estacionamiento()); 
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
            pst = cn.prepareStatement("delete from bicicleta where id_bicicleta=?");
            int reg = pst.executeUpdate();
              pst.setInt(1,bicicleta.getId_bicicleta());
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
