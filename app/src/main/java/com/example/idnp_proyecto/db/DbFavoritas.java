package com.example.idnp_proyecto.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class DbFavoritas extends DbHelper{
    Context context;

    public DbFavoritas(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertarFavorita(String usuario_id, String ruta_id){
        long id = 0;
        try{
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("usuario_id",usuario_id);
            values.put("ruta_id",ruta_id);
            id = db.insert(TABLE_FAVORITAS, null, values);

        }catch (Exception e){
            e.toString();
        }
        return id;
    }

    public boolean eliminarFavorita(String id){
        try{
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            String[] args = new String []{id};
            db.delete(TABLE_FAVORITAS, "id=?", args);
            return true;
        }catch (Exception e){
            e.toString();
        }
        return false;
    }

    public Cursor obtenerIds(){
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        return db.rawQuery("SELECT id FROM t_rutas_favoritas",null);
    }

    public Cursor obtenerFavorita(String id){
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        return db.rawQuery("SELECT * FROM t_rutas_favoritas WHERE id = " + id,null);
    }
}

