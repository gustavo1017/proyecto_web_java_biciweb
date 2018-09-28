/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquiler.daos.impl;
import alquiler.daos.AlquilerDao;
import alquiler.entidades.Alquiler;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import alquiler.util.DbConection;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author THEBEST
 */
public class AlquilerDaoImplStm implements AlquilerDao {
     private Connection cn=null;
    private Statement st;
    private ResultSet rs;
    @Override
    public void create(Alquiler alquiler) {
         try{
            cn = DbConection.getInstance().getConnection();
            st = cn.createStatement();
            int reg = st.executeUpdate("insert into alquiler values ('"+alquiler.getFecha_alquiler()+"','"+alquiler.getPrecio_alquiler());
             
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
    public Alquiler find(int id_cliente, int id_bicicleta) {
        Alquiler alquiler= null;
        try{
            cn = DbConection.getInstance().getConnection();
            st = cn.createStatement();
            rs = st.executeQuery("select * from alquiler where id_cliente='"+id_cliente+"'+and id_bicicleta'"+id_bicicleta+"'");
            if(rs.next()){
                alquiler = new Alquiler(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getDouble(4));
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
        return alquiler;
    }

    @Override
    public List<Alquiler> findAll() {
         List<Alquiler> lista=new ArrayList<>();
        try{
            cn = DbConection.getInstance().getConnection();
            st = cn.createStatement();
            rs = st.executeQuery("select * from alquiler");
            while(rs.next()){
                lista.add(new Alquiler(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDouble(4)));
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
    
}
