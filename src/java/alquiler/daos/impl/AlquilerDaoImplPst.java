/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquiler.daos.impl;
import alquiler.daos.AlquilerDao;
import alquiler.entidades.Alquiler;
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
public class AlquilerDaoImplPst implements AlquilerDao{
     private Connection cn=null;
    private PreparedStatement pst;
    private ResultSet rs;
    @Override
    public void create(Alquiler alquiler) {
        try{
            cn = DbConection.getInstance().getConnection();
            pst = cn.prepareStatement("insert into alquiler(fecha_alquiler,precio_alquiler) values (?,?)");
            pst.setString(1,alquiler.getFecha_alquiler());
            pst.setDouble(2,alquiler.getPrecio_alquiler());
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
    public Alquiler find(int id_cliente, int id_bicicleta) {
            Alquiler alquiler= null;
        try{
            cn = DbConection.getInstance().getConnection();
            pst = cn.prepareStatement("select * from alquiler where id_cliente=? , id_bicicleta=?");
            pst.setInt(1,id_cliente);
            pst.setInt(2,id_bicicleta);
            rs = pst.executeQuery();
            if(rs.next()){
                alquiler = new Alquiler(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDouble(4)) ;
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
            pst = cn.prepareStatement("select * from alquiler");
            rs = pst.executeQuery();
            while(rs.next()){
                lista.add(new  Alquiler(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDouble(4)));
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
