package itson.tracking.servicios;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import itson.tracking.conexion.MongoDBConnection;
import itson.tracking.conversores.ConversorEjercicio;
import itson.tracking.entidades.EjercicioDominio;

/**
 * Clase que representa un servicio de ejercicio dominio.
 * @author David Acosta Fajardo - Raul Alejandro Sauceda Rayos - Francisco de Jesús López Ruiz / ITSON
 */
public class EjercicioDominioServicio {
    ConversorEjercicio conversorEjercicio;
    private MongoCollection<Document> coleccion;
    MongoDBConnection conexion = new MongoDBConnection();
    MongoDatabase database = conexion.getDatabase();

    /**
     * Constructor de la clase EjercicioDominioServicio.
     */
    public EjercicioDominioServicio() {
        this.coleccion = database.getCollection("ejerciciosDominio");
        this.conversorEjercicio = new ConversorEjercicio();
    }

    /**
     * Método que inserta un ejercicio dominio en la base de datos.
     * @param ejercicioDominio
     */
    public void insertarEjercicioDominio(EjercicioDominio ejercicioDominio) {
        if (ejercicioDominio == null) {
            throw new IllegalArgumentException("El ejercicio no puede ser nulo");
        }
        Document doc = conversorEjercicio.convertirEjercicioDominioADocumento(ejercicioDominio);
        coleccion.insertOne(doc);

    }

    /**
     * Método que elimina un ejercicio dominio en la base de datos.
     * @param ejercicioDominio
     */
    public void eliminarEjercicioDominio(EjercicioDominio ejercicioDominio) {
        if (ejercicioDominio == null) {
            throw new IllegalArgumentException("El ejercicio no puede ser nulo");
        }
        Document doc = conversorEjercicio.convertirEjercicioDominioADocumento(ejercicioDominio);
        coleccion.deleteOne(doc);
    }

    /**
     * Método que actualiza un ejercicio dominio en la base de datos.
     * @param ejercicioDominio
     */
    public void actualizarEjercicioDominio(EjercicioDominio ejercicioDominio) {
        if (ejercicioDominio == null) {
            throw new IllegalArgumentException("El ejercicio no puede ser nulo");
        }
        Document doc = conversorEjercicio.convertirEjercicioDominioADocumento(ejercicioDominio);
        coleccion.replaceOne(doc, doc);
    }

    /**
     * Método que busca un ejercicio dominio en la base de datos.
     * @param nombre
     * @return EjercicioDominio
     */
    public EjercicioDominio buscarEjercicioDominio(String nombre) {
        Document doc = coleccion.find(new Document("nombre", nombre)).first();
        return conversorEjercicio.convertirDocumentoAEjercicioDominio(doc);
    }


}
