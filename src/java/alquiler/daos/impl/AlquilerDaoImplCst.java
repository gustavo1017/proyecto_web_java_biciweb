/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquiler.daos.impl;
import alquiler.daos.AlquilerDao;
import alquiler.entidades.Alquiler;
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
public class AlquilerDaoImplCst implements AlquilerDao{
        private Connection cn=null;
    private CallableStatement cst;
    private ResultSet rs;
    @Override
    public void create(Alquiler alquiler) {
           try{
            cn = DbConection.getInstance().getConnection();
            cst = cn.prepareCall("{call sp_insertar_alquiler(?,?,?,?)}");
            cst.setInt(1,alquiler.getId_cliente());
            cst.setInt(2,alquiler.getId_bicicleta());
            cst.setString(3,alquiler.getFecha_alquiler());
            cst.setDouble(4,alquiler.getPrecio_alquiler());
         
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
    public Alquiler find(int id_cliente, int id_bicicleta) {
          Alquiler alquiler= null;
        try{
            cn = DbConection.getInstance().getConnection();
            cst = cn.prepareCall("{call sp_buscar_alquiler(?,?)}");
            cst.setInt(1,id_cliente);
            cst.setInt(2,id_cliente);
            rs = cst.executeQuery();
            if(rs.next()){
                alquiler = new Alquiler(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDouble(4));
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
            cst = cn.prepareCall("{call sp_listar_alquiler()}");
            rs = cst.executeQuery();
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
