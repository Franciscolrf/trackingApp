/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.tracking.entidades;
import org.bson.Document;

/**
 *  Clase que representa un día de la rutina de un plan de entrenamiento
 *  @author David Acosta Fajardo - Raul Alejandro Sauceda Rayos - Francisco de Jesús López Ruiz / ITSON
 */
public class Dia {
    private Rutina rutina;

    /**
     * Constructor de la clase Dia
     * @param rutina
     */
    public Dia(Rutina rutina) {
        this.rutina = rutina;
    }


    public void setRutina(Rutina rutina) {
        this.rutina = rutina;
    }
    
    public Rutina getRutina() {
        return rutina;
    }

    /**
     * Método que convierte un objeto Dia a un documento de MongoDB
     * @return Document
     */
    public Document toDocument() {
        return new Document("rutina", rutina.toDocument());
    }
}
