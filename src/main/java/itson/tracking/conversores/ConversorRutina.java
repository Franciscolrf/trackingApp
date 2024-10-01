
package itson.tracking.conversores;

import org.bson.Document;

import itson.tracking.entidades.Ejercicio;
import itson.tracking.entidades.Rutina;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que convierte una rutina a documento y viceversa
 * 
 * @author David Acosta Fajardo - Raul Alejandro Sauceda Rayos - Francisco de
 *         Jesús López Ruiz / ITSON
 */
public class ConversorRutina {


    public ConversorRutina() {
    }

    /**
     * Método que convierte una rutina a documento
     * @param rutina
     * @return Document
     */
    public Document convertirRutinaADocumento(Rutina rutina) {
        List<Document> ejerciciosDocs = new ArrayList<>();
        for (Ejercicio ejercicio : rutina.getEjercicios()) {
            ejerciciosDocs.add(new ConversorEjercicio().convertirEjercicioADocumento(ejercicio));
        }
        return new Document("ejercicios", ejerciciosDocs);
    }

    /**
     * Método que convierte un documento a rutina
     * @param doc
     * @return Rutina
     */
    public Rutina convertirDocumentoARutina(Document doc) {
        List<Document> ejerciciosDocs = (List<Document>) doc.get("ejercicios");
        List<Ejercicio> ejercicios = new ArrayList<>();
        for (Document ejercicioDoc : ejerciciosDocs) {
            ejercicios.add(new ConversorEjercicio().convertirDocumentoAEjercicio(ejercicioDoc));
        }
        return new Rutina(ejercicios);
    }
}
