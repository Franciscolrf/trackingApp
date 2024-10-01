/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.tracking.servicios;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import itson.tracking.conexion.MongoDBConnection;
import itson.tracking.conversores.ConversorUsuario;
import itson.tracking.entidades.Usuario;

/**
 * Clase que representa acciones de un servicio de usuario en MongoDB
 * 
 * @author David Acosta Fajardo - Raul Alejandro Sauceda Rayos - Francisco de
 *         Jesús López Ruiz / ITSON
 */
public class UsuarioServicio {
    ConversorUsuario conversorUsuario = new ConversorUsuario();
    private MongoCollection<Document> coleccion;
    MongoDBConnection conexion = new MongoDBConnection();
    MongoDatabase database = conexion.getDatabase();

    public UsuarioServicio() {
        this.coleccion = database.getCollection("usuarios");
    }

    /**
     * Método que agrega un usuario
     * 
     * @param usuario
     */
    public void agregarUsuario(Usuario usuario) {
        Document doc = conversorUsuario.convertirUsuarioADocumento(usuario);
        coleccion.insertOne(doc);
    }

    /**
     * Método que actualiza un usuario
     * 
     * @param usuario
     */
    public void actualizarUsuario(Usuario usuario) {
        Document doc = conversorUsuario.convertirUsuarioADocumento(usuario);
        coleccion.replaceOne(eq("nomUsuario", usuario.getNomUsuario()), doc);
    }

    /**
     * Método que elimina un usuario
     * 
     * @param nomUsuario
     */
    public void eliminarUsuario(String nomUsuario) {
        if (nomUsuario == null || nomUsuario.isEmpty()) {
            throw new IllegalArgumentException("El nombre de usuario no puede estar vacío");
        }

        Usuario existingUser = validarExistencia(nomUsuario);
        if (existingUser == null) {
            throw new IllegalArgumentException("El usuario no existe");
        }

        coleccion.deleteOne(eq("nomUsuario", nomUsuario));
    }

    /**
     * Método que valida la existencia de un usuario
     * 
     * @param nomUsuario
     * @return Usuario
     */
    public Usuario validarExistencia(String nomUsuario) {
        Document doc = coleccion.find(new Document("nomUsuario", nomUsuario)).first();
        if (doc != null) {
            return conversorUsuario.convertirDocumentoAUsuario(doc);
        }
        return null;
    }

    /**
     * Método que obtiene un usuario
     * 
     * @param nomUsuario
     * @return Usuario
     */

    public Usuario obtenerUsuario(String nomUsuario) {
        Document doc = coleccion.find(new Document("nomUsuario", nomUsuario)).first();
        if (doc != null) {
            return conversorUsuario.convertirDocumentoAUsuario(doc);
        }
        return null;

    }
}