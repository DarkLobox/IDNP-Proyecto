package com.example.idnp_proyecto.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class DbCalendario extends DbHelper{
    Context context;

    public DbCalendario(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertarCalendario(String usuario_id, String comentario, String fecha, String hora){
        long id = 0;
        try{
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("usuario_id",usuario_id);
            values.put("comentario",comentario);
            values.put("fecha", fecha);
            values.put("hora",hora);
            id = db.insert(TABLE_CALENDARIO, null, values);

        }catch (Exception e){
            e.toString();
        }
        return id;
    }

    public boolean actualizarCalendario(String id, String usuario_id, String comentario, String fecha, String hora){
        try{
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("usuario_id",usuario_id);
            values.put("comentario",comentario);
            values.put("fecha",fecha);
            values.put("hora",hora);
            String[] args = new String []{id};
            db.update(TABLE_CALENDARIO, values, "id=?", args);
            return true;
        }catch (Exception e){
            e.toString();
        }
        return false;
    }

    public boolean eliminarCalendario(String id){
        try{
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            String[] args = new String []{id};
            db.delete(TABLE_CALENDARIO, "id=?", args);
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

    public Cursor obtenerCalendario(String id){
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        return db.rawQuery("SELECT * FROM t_calendario WHERE id = " + id,null);
    }
}
