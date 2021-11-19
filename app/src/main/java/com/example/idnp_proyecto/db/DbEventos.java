package com.example.idnp_proyecto.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class DbEventos extends DbHelper {
    Context context;

    public DbEventos(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertarEvento(String usuario_id, String comentario, String fecha, String hora){
        long id = 0;
        try{
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("usuario_id",usuario_id);
            values.put("comentario",comentario);
            values.put("fecha", fecha);
            values.put("hora",hora);
            id = db.insert(TABLE_EVENTOS, null, values);

        }catch (Exception e){
            e.toString();
        }
        return id;
    }

    public boolean actualizarEvento(String id, String usuario_id, String comentario, String fecha, String hora){
        try{
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("usuario_id",usuario_id);
            values.put("comentario",comentario);
            values.put("fecha",fecha);
            values.put("hora",hora);
            String[] args = new String []{id};
            db.update(TABLE_EVENTOS, values, "id=?", args);
            return true;
        }catch (Exception e){
            e.toString();
        }
        return false;
    }

    public boolean eliminarEvento(String id){
        try{
           DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            String[] args = new String []{id};
            db.delete(TABLE_EVENTOS, "id=?", args);
            return true;
        }catch (Exception e){
            e.toString();
        }
        return false;
    }

    public Cursor obtenerIds(){
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        return db.rawQuery("SELECT id FROM t_calendario",null);
    }

    public Cursor obtenerEvento(String id){
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        return db.rawQuery("SELECT * FROM t_calendario WHERE id = " + id,null);
    }
}

