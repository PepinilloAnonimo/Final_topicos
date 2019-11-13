package com.example.topicos;

import android.content.Context;
import android.util.Log;
import com.couchbase.lite.CouchbaseLiteException;
import com.couchbase.lite.DataSource;
import com.couchbase.lite.Database;
import com.couchbase.lite.DatabaseConfiguration;
import com.couchbase.lite.Expression;
import com.couchbase.lite.Meta;
import com.couchbase.lite.MutableDocument;
import com.couchbase.lite.Query;
import com.couchbase.lite.QueryBuilder;
import com.couchbase.lite.Result;
import com.couchbase.lite.ResultSet;
import com.couchbase.lite.SelectResult;

public class NoSQL {
    Database database;
    DatabaseConfiguration manager;
    public NoSQL(){
    }
    public void conexion(Context context){
        manager = null;
        database = null;
        try {
            manager = new DatabaseConfiguration(context);
            database = new Database("final_topicos", manager);
        }catch (Exception ex) {
            Log.e("TAG", "Error getting database");
            System.out.println("EFE");
        }
    }
    public void calificar(int calificacion, String comentario, String usuario, String producto) {
        MutableDocument mutableDocument = new MutableDocument()
                .setInt("Calificacion", calificacion)
                .setString("Comentario", comentario)
                .setString("Usuario", usuario)
                .setString("Producto", producto);
        try{
            database.save(mutableDocument);
        }catch (CouchbaseLiteException e){
            Log.e("TAG", "Error getting database");
        }

    }
    public void buscar_calificacion(String producto){
        Query query = QueryBuilder
                .select(SelectResult.expression(Meta.id),
                        SelectResult.property("Calificacion"),
                        SelectResult.property("Producto"),
                        SelectResult.property("Usuario"))
                .from(DataSource.database(database))
                .where(Expression.property("Producto").equalTo(Expression.string(producto)));

        try {
            ResultSet rs = query.execute();
            for (Result result : rs) {
                Log.i("Sample", String.format("Usuario -> %s", result.getString("Usuario")));
                Log.i("Sample", String.format("Calificacion -> %s", result.getInt("Calificacion")));
                Log.i("Sample", String.format("Producto -> %s", result.getString("Producto")));
            }
        } catch (CouchbaseLiteException e) {
            Log.e("Sample", e.getLocalizedMessage());
        }
    }
    public void deseos(String usuario, String producto) {
        MutableDocument mutableDocument = new MutableDocument()
                .setString("Usuario", usuario)
                .setString("Producto", producto)
                .setString("Tipo", "lista");
        try{
            database.save(mutableDocument);
        }catch (CouchbaseLiteException e){
            Log.e("TAG", "Error getting database");
        }

    }
    public void buscar_deseos(String usuario){
        Query query = QueryBuilder
                .select(SelectResult.expression(Meta.id),
                        SelectResult.property("Producto"),
                        SelectResult.property("Usuario"))
                .from(DataSource.database(database))
                .where(Expression.property("Usuario").equalTo(Expression.string(usuario))
                        .and((Expression.property("Tipo").equalTo(Expression.string("lista")))));

        try {
            ResultSet rs = query.execute();
            for (Result result : rs) {

                Log.i("Sample", String.format("Usuario -> %s", result.getString("Usuario")));
                Log.i("Sample", String.format("Producto -> %s", result.getString("Producto")));
            }
        } catch (CouchbaseLiteException e) {
            Log.e("Sample", e.getLocalizedMessage());
        }
    }
    public void busqueda(String usuario, String busqueda){
        MutableDocument mutableDocument = new MutableDocument()
                .setString("Usuario", usuario)
                .setString("Producto", busqueda)
                .setString("Tipo", "busqueda");
        try{
            database.save(mutableDocument);
        }catch (CouchbaseLiteException e){
            Log.e("TAG", "Error getting database");
        }
    }
    public void buscar_busquedas(String usuario){
        Query query = QueryBuilder
                .select(SelectResult.expression(Meta.id),
                        SelectResult.property("Producto"),
                        SelectResult.property("Usuario"))
                .from(DataSource.database(database))
                .where(Expression.property("Usuario").equalTo(Expression.string(usuario))
                        .and((Expression.property("Tipo").equalTo(Expression.string("busqueda")))));

        try {
            ResultSet rs = query.execute();
            for (Result result : rs) {

                Log.i("Sample", String.format("Usuario -> %s", result.getString("Usuario")));
                Log.i("Sample", String.format("Producto -> %s", result.getString("Producto")));
            }
        } catch (CouchbaseLiteException e) {
            Log.e("Sample", e.getLocalizedMessage());
        }
    }
}
