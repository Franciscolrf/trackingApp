package itson.tracking.servicios;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import itson.tracking.conexion.MongoDBConnection;
import itson.tracking.conversores.ConversorRutina;
import itson.tracking.entidades.Rutina;

/**
 * Clase que representa un servicio de rutina.
 * @author David Acosta Fajardo - Raul Alejandro Sauceda Rayos - Francisco de Jesús López Ruiz / ITSON
 */
public class RutinaServicio {
    private ConversorRutina conversor;
    private MongoCollection<Document> coleccion;
    MongoDBConnection conexion = new MongoDBConnection();
    MongoDatabase database = conexion.getDatabase();

    public RutinaServicio(MongoDatabase database) {
        this.conversor = new ConversorRutina();
        this.coleccion = database.getCollection("rutinas");
    }

    /**
     * Método que agrega una rutina a la base de datos.
     * @param rutina 
     */
    public void agregarRutina(Rutina rutina) {
        if (rutina == null) {
            throw new IllegalArgumentException("La rutina no puede ser nula");
        }

        Document doc = conversor.convertirRutinaADocumento(rutina);
        coleccion.insertOne(doc);
    }

}
