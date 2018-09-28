/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquiler.entidades;

/**
 *
 * @author THEBEST
 */
public class Encargado {
    private int id_encargado;
    private String nombre_encargado;
    private String apellido_encargado;
    private String telefono_encargado;
    private String direccion_encargado;

    public Encargado() {
    }

    public Encargado( String nombre_encargado, String apellido_encargado, String telefono_encargado, String direccion_encargado) {
        this.nombre_encargado = nombre_encargado;
        this.apellido_encargado = apellido_encargado;
        this.telefono_encargado = telefono_encargado;
        this.direccion_encargado = direccion_encargado;
    }
      public Encargado(int id_encargado, String nombre_encargado, String apellido_encargado, String telefono_encargado, String direccion_encargado) {
          this.id_encargado=id_encargado;
        this.nombre_encargado = nombre_encargado;
        this.apellido_encargado = apellido_encargado;
        this.telefono_encargado = telefono_encargado;
        this.direccion_encargado = direccion_encargado;
    }

    public int getId_encargado() {
        return id_encargado;
    }

    public void setId_encargado(int id_encargado) {
        this.id_encargado = id_encargado;
    }

    public String getNombre_encargado() {
        return nombre_encargado;
    }

    public void setNombre_encargado(String nombre_encargado) {
        this.nombre_encargado = nombre_encargado;
    }

    public String getApellido_encargado() {
        return apellido_encargado;
    }

    public void setApellido_encargado(String apellido_encargado) {
        this.apellido_encargado = apellido_encargado;
    }

    public String getTelefono_encargado() {
        return telefono_encargado;
    }

    public void setTelefono_encargado(String telefono_encargado) {
        this.telefono_encargado = telefono_encargado;
    }

    public String getDireccion_encargado() {
        return direccion_encargado;
    }

    public void setDireccion_encargado(String direccion_encargado) {
        this.direccion_encargado = direccion_encargado;
    }
    
}
