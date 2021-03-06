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
import org.bson.types.ObjectId;

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
    public String eliminarFactura(String id) {

        String web = "";

        MongoClient mongoClient;
        MongoClientURI uri = new MongoClientURI("mongodb://userLab2:passworduserLab2@93.188.167.110:27017/?authSource=lab2");
        mongoClient = new MongoClient(uri);

        MongoDatabase db;
        db = mongoClient.getDatabase("lab2");

        MongoCollection<Document> collection = db.getCollection("facturas");

        boolean excepcion = false;
        Document document = null;

        try {
            document = new Document("_id", new ObjectId(id)); //"5f7f787103a65fd7b5009327"
        } catch (Exception e) {
            web = e.toString();
            excepcion = true;
            web += " ,EL id no es valido";
        }

        if (!excepcion) {
            MongoCursor<Document> resultado = null;
            resultado = collection.find(document).iterator();
            if (resultado != null) {
                web = resultado.toString();

            } else {
                web = "El documento fue eliminado";
                Document resultDocument = collection.findOneAndDelete(document);
            }
        }
        return web;
    }

    public String actualizarDocumento(String id) {

        String web = "";
        MongoClient mongoClient;
        MongoClientURI uri = new MongoClientURI("mongodb://userLab2:passworduserLab2@93.188.167.110:27017/?authSource=lab2");
        mongoClient = new MongoClient(uri);

        MongoDatabase db;
        db = mongoClient.getDatabase("lab2");

        MongoCollection<Document> collection = db.getCollection("proveedores");

        boolean excepcion = false;
        Document document = null;

        try {
            document = new Document("_id", new ObjectId(id)); //"5f7f77e603a65fd7b500931d"
        } catch (Exception e) {
            web = e.toString();
            excepcion = true;
            web += " ,EL id no es valido";
        }
        if (!excepcion) {
            MongoCursor<Document> resultado = null;
            resultado = collection.find(document).iterator();
            if (resultado != null) {
                web = resultado.toString();

            } else {
                web = "El documento fue actualizado";
                
                Document updateDocument = new Document("$set", new Document("nombre", "Juan"));
                Document resultDocument = collection.findOneAndUpdate(document, updateDocument);
            }
        }
        return web;

    }
   
}
