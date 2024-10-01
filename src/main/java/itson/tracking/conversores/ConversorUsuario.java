package itson.tracking.conversores;

import itson.tracking.entidades.Usuario;
import itson.tracking.entidades.PlanEntrenamiento;

import org.bson.Document;

/**
 * Clase que convierte un usuario a documento y viceversa
 * 
 * @author David Acosta Fajardo - Raul Alejandro Sauceda Rayos - Francisco de
 *         Jesús López Ruiz / ITSON
 */
public class ConversorUsuario {

    /**
     * Constructor de la clase
     * 
     * @param database
     */
    public ConversorUsuario() {

    }
    
    /**
     * Método que convierte un usuario a documento
     * 
     * @param usuario
     * @return Document
     */
    public Document convertirUsuarioADocumento(Usuario usuario) {
        Document doc = new Document("nombre", usuario.getNombre())
                .append("nomUsuario", usuario.getNomUsuario())
                .append("edad", usuario.getEdad())
                .append("peso", usuario.getPeso())
                .append("estatura", usuario.getEstatura())
                .append("plan",
                        usuario.getPlanEntrenamiento() != null
                                ? new ConversorPlanEntrenamiento()
                                        .convertirPlanEntrenamientoADocumento(usuario.getPlanEntrenamiento())
                                : null);
        return doc;
    }

    /**
     * Método que convierte un documento a usuario
     * 
     * @param doc
     * @return Usuario
     */
     public Usuario convertirDocumentoAUsuario(Document doc) {
        String nombre = doc.getString("nombre");
        String nomUsuario = doc.getString("nomUsuario");
        int edad = doc.getInteger("edad");
        float peso = doc.getDouble("peso").floatValue();
        float estatura = doc.getDouble("estatura").floatValue();
        PlanEntrenamiento plan = doc.get("plan") != null
                ? new ConversorPlanEntrenamiento().convertirDocumentoAPlanEntrenamiento((Document) doc.get("plan"))
                : null;
        return new Usuario(nombre, nomUsuario, edad, peso, estatura, plan);
    }
}