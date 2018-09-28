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
public class Bicicleta {
        
   private int id_bicicleta;
   private String estado_bicicleta;
   private int id_estacionamiento;

    public Bicicleta() {
    }
     public Bicicleta(int id_bicicleta ,String estado_bicicleta, int id_estacionamiento) {
        this.id_bicicleta=id_bicicleta;
        this.estado_bicicleta = estado_bicicleta;
        this.id_estacionamiento = id_estacionamiento;
    }

    public Bicicleta( String estado_bicicleta, int id_estacionamiento) {
        
        this.estado_bicicleta = estado_bicicleta;
        this.id_estacionamiento = id_estacionamiento;
    }

    public int getId_bicicleta() {
        return id_bicicleta;
    }

    public void setId_bicicleta(int id_bicicleta) {
        this.id_bicicleta = id_bicicleta;
    }

    public String getEstado_bicicleta() {
        return estado_bicicleta;
    }

    public void setEstado_bicicleta(String tamaño_bicicleta) {
        this.estado_bicicleta = tamaño_bicicleta;
    }

    public int getId_estacionamiento() {
        return id_estacionamiento;
    }

    public void setId_estacionamiento(int id_estacionamiento) {
        this.id_estacionamiento = id_estacionamiento;
    }
    
   
    
    
    
    
}
