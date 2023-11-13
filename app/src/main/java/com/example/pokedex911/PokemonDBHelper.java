package com.example.pokedex911;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PokemonDBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "PokemonDB";

    // Tabla de Pokémon
    private static final String TABLE_POKEMON = "pokemon";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_TYPE = "type";
    private static final String KEY_WEIGHT = "weight";
    private static final String KEY_HEIGHT = "height";

    public PokemonDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_POKEMON_TABLE = "CREATE TABLE " + TABLE_POKEMON +
                "(" +
                KEY_ID + " INTEGER PRIMARY KEY," +
                KEY_NAME + " TEXT," +
                KEY_TYPE + " TEXT," +
                KEY_WEIGHT + " TEXT," +
                KEY_HEIGHT + " TEXT" +
                ")";
        db.execSQL(CREATE_POKEMON_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_POKEMON);
        onCreate(db);
    }
    public void insertarPokemon(String nombre, String tipo, String peso, String altura) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, nombre);
        values.put(KEY_TYPE, tipo);
        values.put(KEY_WEIGHT, peso);
        values.put(KEY_HEIGHT, altura);
        db.insert(TABLE_POKEMON, null, values);
        db.close();
    }
    public void deletePokemon(String nombre) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_POKEMON, KEY_NAME + " = ?", new String[]{nombre});
        db.close();
    }


}
