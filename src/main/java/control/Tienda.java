/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
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
    
     public String consultarUltimoEmpleado() {

        String web = null;

        MongoClient mongoClient;
        MongoClientURI uri = new MongoClientURI("mongodb://userLab2:passworduserLab2@93.188.167.110:27017/?authSource=lab2");
        mongoClient = new MongoClient(uri);

        MongoDatabase db;
        db = mongoClient.getDatabase("lab2");

        MongoCollection<Document> collection = db.getCollection("empleados");

        Document document = new Document();
        MongoCursor<Document> resultado = collection.find(document).skip(4).iterator();
        while (resultado.hasNext()) {

            web += resultado.next().toJson();
        }
        return web;

    }

    public String consultarUltimosProductos() {

        String web = "";

        MongoClient mongoClient;
        MongoClientURI uri = new MongoClientURI("mongodb://userLab2:passworduserLab2@93.188.167.110:27017/?authSource=lab2");
        mongoClient = new MongoClient(uri);

        MongoDatabase db;
        db = mongoClient.getDatabase("lab2");

        MongoCollection<Document> collection = db.getCollection("productos");

        Document document = new Document();
        MongoCursor<Document> resultado = collection.find(document).limit(5).iterator();

        while (resultado.hasNext()) {

            web += resultado.next().toJson() + " \n\n";
        }
        return web;
    }
   
}
