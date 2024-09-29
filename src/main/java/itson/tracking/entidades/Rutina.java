/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.tracking.entidades;
import org.bson.Document;
import java.util.List;
import java.util.ArrayList;

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

    /**
     * Método que convierte un objeto Rutina a un documento de MongoDB
     * @return Document
     */
    public Document toDocument() {
        List<Document> documentosEjercicios = new ArrayList<>();
        for (Ejercicio ejercicio : ejercicios) {
            documentosEjercicios.add(ejercicio.toDocument());
        }
        return new Document("ejercicios", documentosEjercicios);
    }
}
