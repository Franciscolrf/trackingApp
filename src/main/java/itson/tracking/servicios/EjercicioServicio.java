package itson.tracking.servicios;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import itson.tracking.conexion.MongoDBConnection;
import itson.tracking.conversores.ConversorEjercicio;
import itson.tracking.entidades.Ejercicio;

/**
 * Clase que representa un servicio de ejercicio.
 * 
 * @author David Acosta Fajardo - Raul Alejandro Sauceda Rayos - Francisco de
 *         Jesús López Ruiz / ITSON
 */
public class EjercicioServicio {
    ConversorEjercicio conversorEjercicio;
    private MongoCollection<Document> coleccion;
    MongoDBConnection conexion = new MongoDBConnection();
    MongoDatabase database = conexion.getDatabase();

    /**
     * Constructor de la clase EjercicioServicio.
     */
    public EjercicioServicio() {
        this.coleccion = database.getCollection("ejercicios");
        this.conversorEjercicio = new ConversorEjercicio();
    }

    /**
     * Método que agrega un ejercicio a la base de datos.
     * 
     * @param ejercicio
     */
    public void agregarEjercicio(Ejercicio ejercicio) {
        if (ejercicio == null) {
            throw new IllegalArgumentException("El ejercicio no puede ser nulo");
        }
        Document doc = conversorEjercicio.convertirEjercicioADocumento(ejercicio);
        coleccion.insertOne(doc);
    }

    /**
     * Método que elimina un ejercicio de la base de datos.
     * 
     * @param ejercicio
     */
    public void eliminarEjercicio(Ejercicio ejercicio) {
        if (ejercicio == null) {
            throw new IllegalArgumentException("El ejercicio no puede ser nulo");
        }
        Document doc = conversorEjercicio.convertirEjercicioADocumento(ejercicio);
        coleccion.deleteOne(doc);
    }

    /**
     * Método que actualiza un ejercicio de la base de datos.
     * 
     * @param ejercicio
     */

    public void actualizarEjercicio(Ejercicio ejercicio) {
        if (ejercicio == null) {
            throw new IllegalArgumentException("El ejercicio no puede ser nulo");
        }
        Document doc = conversorEjercicio.convertirEjercicioADocumento(ejercicio);
        coleccion.replaceOne(doc, doc);
    }

    /**
     * Método que busca un ejercicio en la base de datos.
     * 
     * @param ejercicio
     * @return ejercicio
     */
    public Ejercicio buscarEjercicio(Ejercicio ejercicio) {
        if (ejercicio == null) {
            throw new IllegalArgumentException("El ejercicio no puede ser nulo");
        }
        Document doc = conversorEjercicio.convertirEjercicioADocumento(ejercicio);
        Document docEncontrado = coleccion.find(doc).first();
        return conversorEjercicio.convertirDocumentoAEjercicio(docEncontrado);
    }

}
