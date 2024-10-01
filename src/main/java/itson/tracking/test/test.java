/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package itson.tracking.test;

import com.mongodb.Mongo;

import itson.tracking.conexion.MongoDBConnection;

/**
 *
 * @author Fran
 */
public class test {

    public static void main(String[] args) {

        MongoDBConnection conexion = new MongoDBConnection();
        conexion.close();
    }
}
