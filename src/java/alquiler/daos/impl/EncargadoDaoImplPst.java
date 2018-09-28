/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquiler.daos.impl;
import alquiler.daos.EncargadoDao;
import alquiler.entidades.Cliente;
import alquiler.entidades.Encargado;
import alquiler.util.DbConection;
import alquiler.entidades.Estacionamiento;
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
public class EncargadoDaoImplPst implements EncargadoDao{
        private Connection cn=null;
    private PreparedStatement pst;
    private ResultSet rs;
    @Override
    public void create(Encargado encargado) {
          try{
            cn = DbConection.getInstance().getConnection();
            pst = cn.prepareStatement("insert into encargado (nombre_encargado,apellido_encargado,telefono_encargado,direccion_encargado)  values (?,?,?,?)");
           
            pst.setString(1,encargado.getNombre_encargado());
            pst.setString(2,encargado.getApellido_encargado());
            pst.setString(3,encargado.getTelefono_encargado());
            pst.setString(4,encargado.getDireccion_encargado());
           
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
    public Encargado find(int id) {
                Encargado encargado= null;
        try{
            cn = DbConection.getInstance().getConnection();
            pst = cn.prepareStatement("select * from encargado where id_encargado=?");
            pst.setInt(1,id);
            rs = pst.executeQuery();
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
            pst = cn.prepareStatement("select * from encargado");
            rs = pst.executeQuery();
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
            pst = cn.prepareStatement("update encargado set nombre_encargado=?, apellido_encargado=?, telefono_encargado=?, direccion_encargado=? where id_encargado =?");
            int reg = pst.executeUpdate();
            pst.setString(1,encargado.getNombre_encargado());
            pst.setString(2,encargado.getApellido_encargado()); 
            pst.setString(3,encargado.getTelefono_encargado()); 
            pst.setString(4,encargado.getDireccion_encargado());
             pst.setInt(5,encargado.getId_encargado());
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
            pst = cn.prepareStatement("delete from encargado where id_encargado=?");
            int reg = pst.executeUpdate();
              pst.setInt(1,encargado.getId_encargado());
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
