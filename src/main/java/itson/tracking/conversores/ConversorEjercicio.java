package itson.tracking.conversores;

import org.bson.Document;

import itson.tracking.entidades.Ejercicio;
import itson.tracking.entidades.EjercicioDominio;

/**
 * Clase que convierte un ejercicio a documento y viceversa.
 * @author David Acosta Fajardo - Raul Alejandro Sauceda Rayos - Francisco de Jesús López Ruiz / ITSON
 */
public class ConversorEjercicio {

    /**
     * Constructor de la clase ConversorEjercicio.
     */
    public ConversorEjercicio() {}

    /**
     * Método que convierte un ejercicio a documento.
     * @param ejercicio
     * @return Document
     */
    public Document convertirEjercicioADocumento(Ejercicio ejercicio) {
        return new Document("ejercicio", convertirEjercicioDominioADocumento(ejercicio.getEjercicioDominio()))
                .append("estado", ejercicio.isEstado());
    }

    /**
     * Método que convierte un documento a ejercicio.
     * @param doc
     * @return Ejercicio
     */
    public Ejercicio convertirDocumentoAEjercicio(Document doc) {
        EjercicioDominio ejercicioDominio = convertirDocumentoAEjercicioDominio((Document) doc.get("ejercicio"));
        boolean estado = doc.getBoolean("estado");
        return new Ejercicio(ejercicioDominio, estado);
    }

    /**
     * Método que convierte un ejercicio dominio a documento.
     * @param ejercicio
     * @return Document
     */
    public Document convertirEjercicioDominioADocumento(EjercicioDominio ejercicio) {
        return new Document("nombre", ejercicio.getNombre())
                .append("tipo", ejercicio.getTipo())
                .append("duracion", ejercicio.getDuracion());
    }

    /**
     * Método que convierte un documento a ejercicio dominio.
     * @param doc
     * @return EjercicioDominio
     */
    public EjercicioDominio convertirDocumentoAEjercicioDominio(Document doc) {
        String nombre = doc.getString("nombre");
        String tipo = doc.getString("tipo");
        int duracion = doc.getInteger("duracion");
        return new EjercicioDominio(nombre, tipo, duracion);
    }
}
