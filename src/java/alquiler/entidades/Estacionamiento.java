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
public class Estacionamiento {
    private int id_estacionamiento;
    private String nombre_estacionamiento;
    private String direccion_estacionamiento;
    private int id_encargado;

    public Estacionamiento() {
    }

    public Estacionamiento(int id_estacionamiento, String nombre_estacionamiento, String direccion_estacionamiento, int id_encargado) {
        this.id_estacionamiento = id_estacionamiento;
        this.nombre_estacionamiento = nombre_estacionamiento;
        this.direccion_estacionamiento = direccion_estacionamiento;
        this.id_encargado = id_encargado;
    }
       public Estacionamiento(String nombre_estacionamiento, String direccion_estacionamiento, int id_encargado) {
       
        this.nombre_estacionamiento = nombre_estacionamiento;
        this.direccion_estacionamiento = direccion_estacionamiento;
        this.id_encargado = id_encargado;
    }

    public int getId_estacionamiento() {
        return id_estacionamiento;
    }

    public void setId_estacionamiento(int id_estacionamiento) {
        this.id_estacionamiento = id_estacionamiento;
    }

    public String getNombre_estacionamiento() {
        return nombre_estacionamiento;
    }

    public void setNombre_estacionamiento(String nombre_estacionamiento) {
        this.nombre_estacionamiento = nombre_estacionamiento;
    }

    public String getDireccion_estacionamiento() {
        return direccion_estacionamiento;
    }

    public void setDireccion_estacionamiento(String direccion_estacionamiento) {
        this.direccion_estacionamiento = direccion_estacionamiento;
    }

    public int getId_encargado() {
        return id_encargado;
    }

    public void setId_encargado(int id_encargado) {
        this.id_encargado = id_encargado;
    }
    
}
