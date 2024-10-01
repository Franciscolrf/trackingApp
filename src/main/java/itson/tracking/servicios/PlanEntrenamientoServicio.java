package itson.tracking.servicios;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import itson.tracking.conexion.MongoDBConnection;
import itson.tracking.conversores.ConversorPlanEntrenamiento;
import itson.tracking.entidades.PlanEntrenamiento;

/**
 * Clase que representa un servicio de planes de entrenamiento
 * 
 * @author David Acosta Fajardo - Raul Alejandro Sauceda Rayos - Francisco de
 *         Jesús López Ruiz / ITSON
 */
public class PlanEntrenamientoServicio {
    private ConversorPlanEntrenamiento conversor;
    private MongoCollection<Document> coleccion;
    MongoDBConnection conexion = new MongoDBConnection();
    MongoDatabase database = conexion.getDatabase();

    /**
     * Constructor de la clase PlanEntrenamientoServicio
     * 
     * @param database
     */
    public PlanEntrenamientoServicio(MongoDatabase database) {
        this.coleccion = database.getCollection("planesEntrenamiento");
        this.conversor = new ConversorPlanEntrenamiento();
    }

    /**
     * Método para agregar un plan de entrenamiento
     * 
     * @param plan
     */
    public void agregarPlanEntrenamiento(PlanEntrenamiento plan) {
        if (plan == null) {
            throw new IllegalArgumentException("El plan de entrenamiento no puede ser nulo");
        }

        coleccion.insertOne(conversor.convertirPlanEntrenamientoADocumento(plan));

    }

}
