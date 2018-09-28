/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquiler.daos.impl;
import alquiler.daos.BicicletaDao;
import alquiler.entidades.Bicicleta;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import alquiler.entidades.Cliente;
import alquiler.util.DbConection;
/**
 *
 * @author THEBEST
 */
public class BicicletaDaoImplStm implements BicicletaDao {
     private Connection cn=null;
    private Statement st;
    private ResultSet rs;
    @Override
    public void create(Bicicleta bicicleta) {
              try{
            cn = DbConection.getInstance().getConnection();
            st = cn.createStatement();
            int reg = st.executeUpdate("insert into bicicleta values ('" 
                    + bicicleta.getEstado_bicicleta() + "','"+bicicleta.getId_estacionamiento()+"')");
             
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
            st = cn.createStatement();
            rs = st.executeQuery("select * from bicicleta where id_bicicleta='"+id+"'");
            if(rs.next()){
                bicicleta = new Bicicleta( rs.getInt(1),rs.getString(2),rs.getInt(3));
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
            st = cn.createStatement();
            rs = st.executeQuery("select * from bicicleta");
            while(rs.next()){
                lista.add(new Bicicleta(rs.getInt(1),rs.getString(2) , rs.getInt(3)));
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
            st = cn.createStatement();
            int reg = st.executeUpdate("update bicicleta set estado_bicicleta='"+bicicleta.getEstado_bicicleta()+
                    "', id_estacionamiento='"+bicicleta.getId_estacionamiento()+
                    "' where id_bicicleta='"+bicicleta.getId_bicicleta()+"';");
             
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
            st = cn.createStatement();
            int reg = st.executeUpdate("delete from bicicleta where id_bicicleta='"+bicicleta.getId_bicicleta()+"'");
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
