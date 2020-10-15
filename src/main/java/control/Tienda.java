/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 *
 * @author caro
 */
public class Tienda {

    public String consultarPrimerCliente() {

        MongoClient mongoClient;
        MongoClientURI uri = new MongoClientURI("mongodb://userLab2:passworduserLab2@93.188.167.110:27017/?authSource=lab2");
        mongoClient = new MongoClient(uri);

        MongoDatabase db;
        db = mongoClient.getDatabase("lab2");

        MongoCollection<Document> collection = db.getCollection("clientes");

        //Mostrar primer registro
        return collection.find().first().toJson();
    }

   
}
