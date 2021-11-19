package com.example.idnp_proyecto.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class DbRutas extends DbHelper{
    Context context;

    public DbRutas(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertarRuta(String empresa, String letra, String hora_incio, String hora_final){
        long id = 0;
        try{
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("empresa",empresa);
            values.put("letra",letra);
            values.put("hora_incio", hora_incio);
            values.put("hora_final",hora_final);
            id = db.insert(TABLE_RUTAS, null, values);

        }catch (Exception e){
            e.toString();
        }
        return id;
    }

    public boolean actualizarRuta(String id, String empresa, String letra, String hora_incio, String hora_final){
        try{
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("empresa",empresa);
            values.put("letra",letra);
            values.put("hora_incio",hora_incio);
            values.put("hora_final",hora_final);
            String[] args = new String []{id};
            db.update(TABLE_RUTAS, values, "id=?", args);
            return true;
        }catch (Exception e){
            e.toString();
        }
        return false;
    }

    public boolean eliminarRuta(String id){
        try{
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            String[] args = new String []{id};
            db.delete(TABLE_RUTAS, "id=?", args);
            return true;
        }catch (Exception e){
            e.toString();
        }
        return false;
    }

    public Cursor obtenerIds(){
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        return db.rawQuery("SELECT id FROM t_rutas",null);
    }

    public Cursor obtenerRuta(String id){
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        return db.rawQuery("SELECT * FROM t_rutas WHERE id = " + id,null);
    }
}
