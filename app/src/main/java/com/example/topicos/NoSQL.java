package com.example.topicos;
import com.mongodb.MongoClient;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;

public class NoSQL {

    public NoSQL(){

    }

    private static MongoClient crearConexion() {
        MongoClient mongo = null;
        try {
            mongo = new MongoClient("192.168.1.2");
        } catch (Error e) {
            System.out.println(e.getCause());
        }

        return mongo;
    }
    public static void calificar (int calificacion, String comentario, String usuario, String producto){
        MongoClient mongo;
        mongo = crearConexion();
        DB finalTopicos = mongo.getDB("finalTopicos");
        DBCollection collection;
        collection = finalTopicos.getCollection("calificaciones");
        BasicDBObject info = new BasicDBObject();
        info.put("Usuario", usuario);
        info.put("Producto", producto);
        info.put("Calificacion", calificacion);
        info.put("Comentario", comentario);
        collection.insert(info);

    }
    public static void lista_deseos (String producto, String usuario){
        MongoClient mongo = crearConexion();
        DB finalTopicos = mongo.getDB("finalTopicos");
        DBCollection collection = finalTopicos.getCollection("deseos");
        BasicDBObject info = new BasicDBObject();
        info.put("Usuario", usuario);
        info.put("Producto", producto);
        collection.insert(info);
    }
    public static void busquedas (String producto, String usuario){
        MongoClient mongo = crearConexion();
        DB finalTopicos = mongo.getDB("finalTopicos");
        DBCollection collection = finalTopicos.getCollection("busqueda");
        BasicDBObject info = new BasicDBObject();
        info.put("Usuario", usuario);
        info.put("Producto", producto);
        collection.insert(info);
    }
}
