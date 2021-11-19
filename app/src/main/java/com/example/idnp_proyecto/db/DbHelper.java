package com.example.idnp_proyecto.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NOMBRE = "proyecto.database";
    public static final String TABLE_USUARIOS = "t_usuarios";
    public static final String TABLE_RUTAS = "t_rutas";
    public static final String TABLE_FAVORITAS = "t_favoritas";
    public static final String TABLE_EVENTOS = "t_eventos";

    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_USUARIOS + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT NOT NULL," +
                "contraseña TEXT NOT NULL," +
                "numero INTEGER NOT NULL," +
                "correo_electronico TEXT NOT NULL)");

        db.execSQL("CREATE TABLE " + TABLE_RUTAS + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "empresa TEXT NOT NULL," +
                "letra TEXT NOT NULL," +
                "hora_inicio NUMERIC NOT NULL," +
                "hora_final NUMERIC NOT NULL)");

        db.execSQL("CREATE TABLE " + TABLE_FAVORITAS + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "usuario_id INTEGER NOT NULL," +
                "ruta_id INTEGER NOT NULL)");

        db.execSQL("CREATE TABLE " + TABLE_EVENTOS + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "usuario_id INTEGER NOT NULL," +
                "comentario TEXT NOT NULL," +
                "fecha NUMERIC NOT NULL," +
                "hora NUMERIC NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE " + TABLE_USUARIOS);
        db.execSQL("DROP TABLE " + TABLE_RUTAS);
        db.execSQL("DROP TABLE " + TABLE_FAVORITAS);
        db.execSQL("DROP TABLE " + TABLE_EVENTOS);
        onCreate(db);
    }
}
