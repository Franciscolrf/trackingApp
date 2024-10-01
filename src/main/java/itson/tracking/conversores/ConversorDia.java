/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.tracking.conversores;

import itson.tracking.entidades.Dia;
import itson.tracking.entidades.Rutina;
import itson.tracking.servicios.DiaServicio;
import org.bson.Document;


/**
 * Clase que convierte un día a documento y viceversa
 * @author David Acosta Fajardo - Raul Alejandro Sauceda Rayos - Francisco de Jesús López Ruiz / ITSON
 */
public class ConversorDia {
    DiaServicio diaServicio = new DiaServicio();

    /**
     * Constructor de la clase ConversorDia
     */
    public ConversorDia() { 
    }

    /**
     * Método que convierte un día a documento
     * @param dia
     * @return Document
     */
    public Document convertirDiaADocumento(Dia dia) {
        return new Document("rutina", new ConversorRutina().convertirRutinaADocumento(dia.getRutina()));
    }

    /**
     * Método que convierte un documento a día
     * @param doc
     * @return Dia
     */
    public Dia convertirDocumentoADia(Document doc) {
        Rutina rutina = new ConversorRutina().convertirDocumentoARutina((Document) doc.get("rutina"));
        return new Dia(rutina);
    }
}
