/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.tracking.entidades;

/**
 *  Clase que representa un ejercicio de una rutina de un plan de entrenamiento
 *  @author David Acosta Fajardo - Raul Alejandro Sauceda Rayos - Francisco de Jesús López Ruiz / ITSON
 */
public class Ejercicio {
    private EjercicioDominio ejercicioDominio;
    private boolean estado;

    /**
     * Constructor de la clase Ejercicio con todos los atributos
     * @param ejercicioDominio
     * @param estado
     */
    public Ejercicio(EjercicioDominio ejercicioDominio, boolean estado) {
        this.ejercicioDominio = ejercicioDominio;
        this.estado = estado;
    }

 

    public EjercicioDominio getEjercicioDominio() {
        return ejercicioDominio;
    }



    public void setEjercicioDominio(EjercicioDominio ejercicioDominio) {
        this.ejercicioDominio = ejercicioDominio;
    }



    public boolean isEstado() {
        return estado;
    }



    public void setEstado(boolean estado) {
        this.estado = estado;
    }


}
