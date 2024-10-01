/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.tracking.servicios;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import itson.tracking.conexion.MongoDBConnection;
import itson.tracking.conversores.ConversorDia;
import itson.tracking.entidades.Dia;

/**
 * Clase que representa un servicio de días.
 * @author David Acosta Fajardo - Raul Alejandro Sauceda Rayos - Francisco de Jesús López Ruiz / ITSON
 */
public class DiaServicio {
    private ConversorDia conversor;
    private MongoCollection<Document> coleccion;
    MongoDBConnection conexion = new MongoDBConnection();
    MongoDatabase database = conexion.getDatabase();

    /**
     * Constructor de la clase DiaServicio.
     */
    public DiaServicio() {
        this.conversor = new ConversorDia();
        this.coleccion = database.getCollection("dias");
    }

    /**
     * Método que agrega un día a la base de datos.
     * @param dia 
     */
    public void agregarDia(Dia dia) {
        if (dia == null) {
            throw new IllegalArgumentException("El día no puede ser nulo");
        }

        Document doc = conversor.convertirDiaADocumento(dia);
        coleccion.insertOne(doc);
    }

}
