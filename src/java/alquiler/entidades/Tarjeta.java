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
public class Tarjeta {
    private int id_tarjeta;
    private String numero_tarjeta;
    private String nombre_tarjeta;
    private String tipo_tarjeta;
    private String fecha_ven_tarjeta;

    public Tarjeta() {
    }

    public Tarjeta(int id_tarjeta, String numero_tarjeta, String nombre_tarjeta, String tipo_tarjeta, String fecha_ven_tarjeta) {
        this.id_tarjeta = id_tarjeta;
        this.numero_tarjeta = numero_tarjeta;
        this.nombre_tarjeta = nombre_tarjeta;
        this.tipo_tarjeta = tipo_tarjeta;
        this.fecha_ven_tarjeta = fecha_ven_tarjeta;
        
    }
       public Tarjeta( String numero_tarjeta, String nombre_tarjeta, String tipo_tarjeta, String fecha_ven_tarjeta) {
        
        this.numero_tarjeta = numero_tarjeta;
        this.nombre_tarjeta = nombre_tarjeta;
        this.tipo_tarjeta = tipo_tarjeta;
        this.fecha_ven_tarjeta = fecha_ven_tarjeta;
    }

 


    public int getId_tarjeta() {
        return id_tarjeta;
    }

    public void setId_tarjeta(int id_tarjeta) {
        this.id_tarjeta = id_tarjeta;
    }

    public String getNumero_tarjeta() {
        return numero_tarjeta;
    }

    public void setNumero_tarjeta(String numero_tarjeta) {
        this.numero_tarjeta = numero_tarjeta;
    }

    public String getNombre_tarjeta() {
        return nombre_tarjeta;
    }

    public void setNombre_tarjeta(String nombre_tarjeta) {
        this.nombre_tarjeta = nombre_tarjeta;
    }

    public String getTipo_tarjeta() {
        return tipo_tarjeta;
    }

    public void setTipo_tarjeta(String tipo_tarjeta) {
        this.tipo_tarjeta = tipo_tarjeta;
    }

    public String getFecha_ven_tarjeta() {
        return fecha_ven_tarjeta;
    }

    public void setFecha_ven_tarjeta(String fecha_ven_tarjeta) {
        this.fecha_ven_tarjeta = fecha_ven_tarjeta;
    }
    
    
    
}
