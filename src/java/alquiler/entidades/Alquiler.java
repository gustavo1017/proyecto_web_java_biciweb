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
public class Alquiler {
    private int id_cliente;
    private int id_bicicleta;
    private String fecha_alquiler;
    private double precio_alquiler;

    public Alquiler() {
    }

    public Alquiler(int id_cliente, int id_bicicleta, String fecha_alquiler, double precio_alquiler) {
        this.id_cliente = id_cliente;
        this.id_bicicleta = id_bicicleta;
        this.fecha_alquiler = fecha_alquiler;
        this.precio_alquiler = precio_alquiler;
    }
      public Alquiler( int id_bicicleta, String fecha_alquiler, double precio_alquiler) {
       
        this.id_bicicleta = id_bicicleta;
        this.fecha_alquiler = fecha_alquiler;
        this.precio_alquiler = precio_alquiler;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_bicicleta() {
        return id_bicicleta;
    }

    public void setId_bicicleta(int id_bicicleta) {
        this.id_bicicleta = id_bicicleta;
    }

    public String getFecha_alquiler() {
        return fecha_alquiler;
    }

    public void setFecha_alquiler(String fecha_alquiler) {
        this.fecha_alquiler = fecha_alquiler;
    }

    public double getPrecio_alquiler() {
        return precio_alquiler;
    }

    public void setPrecio_alquiler(double precio_alquiler) {
        this.precio_alquiler = precio_alquiler;
    }
    
    
}
