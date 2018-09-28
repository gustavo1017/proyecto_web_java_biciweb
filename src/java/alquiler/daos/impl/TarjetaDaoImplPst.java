/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquiler.daos.impl;
import alquiler.daos.TarjetaDao;
import alquiler.entidades.Encargado;
import alquiler.entidades.Tarjeta;
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
public class TarjetaDaoImplPst implements TarjetaDao{
           private Connection cn=null;
    private PreparedStatement pst;
    private ResultSet rs;
    @Override
    public void create(Tarjeta tarjeta) {
             try{
            cn = DbConection.getInstance().getConnection();
            pst = cn.prepareStatement("insert into tarjeta (numero_tarjeta,nombre_tarjeta,tipo_tarjeta,fecha_vencimiento)  values (?,?,?,?)");
           
            pst.setString(1,tarjeta.getNumero_tarjeta());
            pst.setString(1,tarjeta.getNombre_tarjeta());
            pst.setString(1,tarjeta.getTipo_tarjeta());
            pst.setString(1,tarjeta.getFecha_ven_tarjeta());
           
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
    public Tarjeta find(int id) {
                  Tarjeta tarjeta= null;
        try{
            cn = DbConection.getInstance().getConnection();
            pst = cn.prepareStatement("select * from tarjeta where id_tarjeta=?");
            pst.setInt(1,id);
            rs = pst.executeQuery();
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
            pst = cn.prepareStatement("select * from tarjeta");
            rs = pst.executeQuery();
            while(rs.next()){
                lista.add( new Tarjeta(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
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
            pst = cn.prepareStatement("update tarjeta set numero_tarjeta=?, nombre_tarjeta=?, tipo_tarjeta=?, fecha_vencimiento=? where id_tarjeta =?");
            int reg = pst.executeUpdate();
            pst.setString(1,tarjeta.getNumero_tarjeta());
            pst.setString(2,tarjeta.getNombre_tarjeta()); 
            pst.setString(3,tarjeta.getTipo_tarjeta()); 
            pst.setString(4,tarjeta.getFecha_ven_tarjeta());
             pst.setInt(5,tarjeta.getId_tarjeta());
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
            pst = cn.prepareStatement("delete from tarjeta where id_tarjeta=?");
            int reg = pst.executeUpdate();
              pst.setInt(1,tarjeta.getId_tarjeta());
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
