/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquiler.daos.impl;
import alquiler.daos.EncargadoDao;
import alquiler.entidades.Bicicleta;
import alquiler.entidades.Encargado;
import alquiler.util.DbConection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import alquiler.util.DbConection;
import java.util.ArrayList;
/**
 *
 * @author THEBEST
 */
public class EncargadoDaoImplStm implements EncargadoDao {
     private Connection cn=null;
    private Statement st;
    private ResultSet rs;

  
    @Override
    public void create(Encargado encargado) {
                try{
            cn = DbConection.getInstance().getConnection();
            st = cn.createStatement();
            int reg = st.executeUpdate("insert into encargado (nombre_encargado,apellido_encargado,telefono_encargado,direccion_encargado)  values ('" + encargado.getNombre_encargado() + "','" 
                    + encargado.getApellido_encargado() + "','"+encargado.getTelefono_encargado()+"','"+encargado.getDireccion_encargado()+"')");
             
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
            st = cn.createStatement();
            rs = st.executeQuery("select * from encargado where id_encargado='"+id+"'");
            if(rs.next()){
                encargado = new Encargado( rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
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
            st = cn.createStatement();
            rs = st.executeQuery("select * from encargado");
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
            st = cn.createStatement();
            int reg = st.executeUpdate("update encargado set nombre_encargado='"+encargado.getNombre_encargado()+
                    "', apellido_encargado='"+encargado.getApellido_encargado()+
                    "', telefono_encargado='"+encargado.getTelefono_encargado()+
                    "', direccion_encargado='"+encargado.getDireccion_encargado()+
                    "' where id_encargado='"+encargado.getId_encargado()+"';");
             
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
            st = cn.createStatement();
            int reg = st.executeUpdate("delete from encargado where id_encargado='"+encargado.getId_encargado()+"'");
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
