package com.example.pokedex911;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetallePokemonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_pokemon);

        // Recuperar los extras del Intent
        Intent intent = getIntent();
        String nombrePokemon = intent.getStringExtra("pokemon_name");
        TextView nombreTextView = findViewById(R.id.nombrePokemonTextView);
        nombreTextView.setText(nombrePokemon);
    }


}