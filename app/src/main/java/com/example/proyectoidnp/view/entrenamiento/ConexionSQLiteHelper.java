package com.example.proyectoidnp.view.entrenamiento;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ConexionSQLiteHelper extends SQLiteOpenHelper {
    final String CREAR_TABLA_ENTRENAMIENTO="CREATE TABLE entrenamiento(EntId INTEGER, EntUsuId INTEGER, EntRecId INTEGER, EntTip TEXT, EntDur INTEGER)";
    public ConexionSQLiteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREAR_TABLA_ENTRENAMIENTO);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS entrenamiento");
    }
}
