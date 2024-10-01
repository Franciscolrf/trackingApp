package itson.tracking.conversores;

import org.bson.Document;


import itson.tracking.entidades.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que convierte un plan de entrenamiento a documento y viceversa
 * @author David Acosta Fajardo - Raul Alejandro Sauceda Rayos - Francisco de Jesús López Ruiz / ITSON
 */
public class ConversorPlanEntrenamiento {



    /**
     * Constructor de la clase PlanEntrenamientoRepositorio
     */
    public ConversorPlanEntrenamiento() {
    }



    /**
     * Método para convertir un plan de entrenamiento a documento
     * @param plan
     * @return Document
     */
    public Document convertirPlanEntrenamientoADocumento(PlanEntrenamiento plan) {
        List<Document> diasDocs = new ArrayList<>();
        for (Dia dia : plan.getDias()) {
            diasDocs.add(new ConversorDia().convertirDiaADocumento(dia));
        }
        return new Document("dias", diasDocs)
                .append("fechaInicial", plan.getFechaInicial())
                .append("fechaFinal", plan.getFechaFinal());
    }

    /**
     * Método para convertir un documento a plan de entrenamiento
     * @param doc
     * @return PlanEntrenamiento
     */
    public PlanEntrenamiento convertirDocumentoAPlanEntrenamiento(Document doc) {
        List<Document> diasDocs = (List<Document>) doc.get("dias");
        List<Dia> dias = new ArrayList<>();
        for (Document diaDoc : diasDocs) {
            dias.add(new ConversorDia().convertirDocumentoADia(diaDoc));
        }
        return new PlanEntrenamiento(dias, doc.getDate("fechaInicial"), doc.getDate("fechaFinal"));
    }
}