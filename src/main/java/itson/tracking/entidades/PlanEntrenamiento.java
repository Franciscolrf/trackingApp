/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.tracking.entidades;
import org.bson.Document;
import java.util.List;
import java.util.ArrayList;

/**
 *  Clase que representa un plan de entrenamiento
 *  @author David Acosta Fajardo - Raul Alejandro Sauceda Rayos - Francisco de Jesús López Ruiz / ITSON
 */
public class PlanEntrenamiento {
    private List<Dia> dias;
    private String fechaInicial;
    private String fechaFinal;

    /**
     * Constructor de la clase PlanEntrenamiento con todos los atributos
     * @param dias
     * @param fechaInicial
     * @param fechaFinal
     */
    public PlanEntrenamiento(List<Dia> dias, String fechaInicial, String fechaFinal) {
        this.dias = dias;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
    }


    public List<Dia> getDias() {
        return dias;
    }


    public void setDias(List<Dia> dias) {
        this.dias = dias;
    }


    public String getFechaInicial() {
        return fechaInicial;
    }


    public void setFechaInicial(String fechaInicial) {
        this.fechaInicial = fechaInicial;
    }


    public String getFechaFinal() {
        return fechaFinal;
    }


    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }


    /**
     * Convierte el plan de entrenamiento a un documento de MongoDB
     * @return Document
     */
    public Document toDocument() {
        List<Document> documentosDias = new ArrayList<>();
        for (Dia dia : dias) {
            documentosDias.add(dia.toDocument());
        }

        return new Document("dias", documentosDias)
            .append("fechaInicial", fechaInicial)
            .append("fechaFinal", fechaFinal);
    }
}