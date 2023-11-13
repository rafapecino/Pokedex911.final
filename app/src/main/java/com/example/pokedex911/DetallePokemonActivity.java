package com.example.pokedex911;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class DetallePokemonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_pokemon);

        // Recuperar los extras del Intent
        Intent intent = getIntent();
        String nombrePokemon = intent.getStringExtra("pokemon_name");
        TextView nombreTextView = findViewById(R.id.nombrePokemonTextView);
        ImageView fotoImageView = findViewById(R.id.fotoImageView);
        nombreTextView.setText(nombrePokemon);
        String url = intent.getStringExtra("pokmon_image_url");
        Glide.with(this).load(url).centerCrop().diskCacheStrategy(DiskCacheStrategy.ALL).into(fotoImageView);
    }


}