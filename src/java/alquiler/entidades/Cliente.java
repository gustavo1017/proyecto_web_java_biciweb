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
public class Cliente {
    private int id_cliente;
    private String nombre_cliente;
    private String apellido_cliente;
    private String dni_cliente;
    private String nombre_usuario_cliente;
    private String clave_usuario_cliente;
    private int id_tarjeta;

    public Cliente() {
    }

    public Cliente( String nombre_cliente, String apellido_cliente, String dni_cliente, String nombre_usuario_cliente, String clave_usuario_cliente, int id_tarjeta) {
        
        this.nombre_cliente = nombre_cliente;
        this.apellido_cliente = apellido_cliente;
        this.dni_cliente = dni_cliente;
        this.nombre_usuario_cliente = nombre_usuario_cliente;
        this.clave_usuario_cliente = clave_usuario_cliente;
        this.id_tarjeta = id_tarjeta;
    }
       public Cliente( int id_cliente,String nombre_cliente, String apellido_cliente, String dni_cliente, String nombre_usuario_cliente, String clave_usuario_cliente, int id_tarjeta) {
        this.id_cliente=id_cliente;
        this.nombre_cliente = nombre_cliente;
        this.apellido_cliente = apellido_cliente;
        this.dni_cliente = dni_cliente;
        this.nombre_usuario_cliente = nombre_usuario_cliente;
        this.clave_usuario_cliente = clave_usuario_cliente;
        this.id_tarjeta = id_tarjeta;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getApellido_cliente() {
        return apellido_cliente;
    }

    public void setApellido_cliente(String apellido_cliente) {
        this.apellido_cliente = apellido_cliente;
    }

    public String getDni_cliente() {
        return dni_cliente;
    }

    public void setDni_cliente(String dni_cliente) {
        this.dni_cliente = dni_cliente;
    }

    public String getNombre_usuario_cliente() {
        return nombre_usuario_cliente;
    }

    public void setNombre_usuario_cliente(String nombre_usuario_cliente) {
        this.nombre_usuario_cliente = nombre_usuario_cliente;
    }

    public String getClave_usuario_cliente() {
        return clave_usuario_cliente;
    }

    public void setClave_usuario_cliente(String clave_usuario_cliente) {
        this.clave_usuario_cliente = clave_usuario_cliente;
    }

    public int getId_tarjeta() {
        return id_tarjeta;
    }

    public void setId_tarjeta(int id_tarjeta) {
        this.id_tarjeta = id_tarjeta;
    }

    

    
    
}
