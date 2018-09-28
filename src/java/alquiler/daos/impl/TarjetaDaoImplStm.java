/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquiler.daos.impl;
import alquiler.util.DbConection;

import alquiler.daos.TarjetaDao;
import alquiler.entidades.Bicicleta;
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
public class TarjetaDaoImplStm implements TarjetaDao{
     private Connection cn=null;
    private Statement st;
    private ResultSet rs;
    @Override
    public void create(Tarjeta tarjeta) {
            try{
            cn = DbConection.getInstance().getConnection();
            st = cn.createStatement();
            int reg = st.executeUpdate("insert into tarjeta values ('" 
                    + tarjeta.getNumero_tarjeta() + "','"+tarjeta.getNombre_tarjeta()+ "','"+ tarjeta.getTipo_tarjeta() +"','"+tarjeta.getFecha_ven_tarjeta()+   "')");
             
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
            st = cn.createStatement();
            rs = st.executeQuery("select * from tarjeta where id_tarjeta='"+id+"'");
            if(rs.next()){
                tarjeta= new Tarjeta(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
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
            st = cn.createStatement();
            rs = st.executeQuery("select * from bicicleta");
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
            st = cn.createStatement();
            int reg = st.executeUpdate("update tarjeta set numero_tarjeta='"+tarjeta.getNumero_tarjeta()+
                    "', nombre_tarjeta='"+tarjeta.getNombre_tarjeta()+
                     "', tipo_tarjeta='"+tarjeta.getTipo_tarjeta()+
                     "', fecha_vencimiento='"+tarjeta.getFecha_ven_tarjeta()+
                    "' where id_tarjeta='"+tarjeta.getId_tarjeta()+"';");
             
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
            st = cn.createStatement();
            int reg = st.executeUpdate("delete from tarjeta where id_tarjeta='"+tarjeta.getId_tarjeta()+"'");
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
