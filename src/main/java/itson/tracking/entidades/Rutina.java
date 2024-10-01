/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.tracking.entidades;
import java.util.List;

/**
 *  Clase que representa una rutina de un plan de entrenamiento
 *  @author David Acosta Fajardo - Raul Alejandro Sauceda Rayos - Francisco de Jesús López Ruiz / ITSON
 */
public class Rutina {
    private List<Ejercicio> ejercicios;

    /**
     * Constructor de la clase Rutina con todos los atributos
     * @param ejercicios
     */
    public Rutina(List<Ejercicio> ejercicios) {
        this.ejercicios = ejercicios;
    }


    public void setEjercicios(List<Ejercicio> ejercicios) {
        this.ejercicios = ejercicios;
    }

    public List<Ejercicio> getEjercicios() {
        return ejercicios;
    }

}
