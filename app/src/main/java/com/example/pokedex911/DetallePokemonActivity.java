package com.example.pokedex911;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetallePokemonActivity extends AppCompatActivity {

    private Retrofit retrofit;
    private boolean aptoParaCargar;
    private ListaPokemonAdapter listaPokemonAdapter;
    private PokemonDBHelper dbHelper;

    private int offset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_pokemon);
        dbHelper = new PokemonDBHelper(this);


        // Recuperar los extras del Intent
        Intent intent = getIntent();

        String nombrePokemon = intent.getStringExtra("pokemon_name");
        TextView nombreTextView = findViewById(R.id.nombrePokemonTextView);
        ImageView fotoImageView = findViewById(R.id.fotoImageView);
        TextView tipoTextView = findViewById(R.id.tipoPokemonTextView);
        nombreTextView.setText(nombrePokemon);
        String url = intent.getStringExtra("pokmon_image_url");
        Glide.with(this).load(url).centerCrop().diskCacheStrategy(DiskCacheStrategy.ALL).into(fotoImageView);
        retrofit = new Retrofit.Builder().baseUrl("https://pokeapi.co/api/v2/").addConverterFactory(GsonConverterFactory.create()).build();
        aptoParaCargar = true;
        offset = 0;
        Button favoritosButton = findViewById(R.id.favoritosButton);
        favoritosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener los detalles del Pokémon (nombre, tipo, peso, altura)
                String nombrePokemon = nombreTextView.getText().toString();
                String tipoPokemon = tipoTextView.getText().toString();
                String pesoPokemon = "0";
                String alturaPokemon = "0";
                // Aquí asegúrate de obtener el tipo del Pokémon
                // Peso y altura, puedes obtenerlos de la API o pasarlos como extras en el Intent

                // Insertar el Pokémon en la base de datos
                dbHelper.insertarPokemon(nombrePokemon,tipoPokemon,pesoPokemon,alturaPokemon); // Aquí asegúrate de pasar el peso y la altura correctos

                // Mostrar un mensaje al usuario indicando que el Pokémon se ha agregado a favoritos
                Toast.makeText(DetallePokemonActivity.this, "¡Pokemon agregado a favoritos!", Toast.LENGTH_SHORT).show();
                Button quitarFavoritosButton = findViewById(R.id.quitarFavoritosButton);
                quitarFavoritosButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String nombrePokemon = nombreTextView.getText().toString();
                        dbHelper.deletePokemon(nombrePokemon);
                        Toast.makeText(DetallePokemonActivity.this, "¡Pokemon eliminado de favoritos!", Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });


    }
    private void obtenerTipo(){
        PokeapiService service = retrofit.create(PokeapiService.class);
        Call<PokemonRespuesta> pokemonRespuestaCall = service.obtenerTipo(807, offset);
        pokemonRespuestaCall.enqueue(new Callback<PokemonRespuesta>() {
            @Override
            public void onResponse(Call<PokemonRespuesta> call, Response<PokemonRespuesta> response) {
                aptoParaCargar = true;
                if (response.isSuccessful()){
                    PokemonRespuesta pokemonRespuesta = response.body();
                    pokemonRespuesta.getResults();
                    ArrayList<Pokemon> listaPokemon = pokemonRespuesta.getResults();
                    listaPokemonAdapter.adicionarListaPokemon(listaPokemon);
                }else{
                    Log.e(TAG, " onResponse: " + response.errorBody());
                }
            }
            @Override
            public void onFailure(Call<PokemonRespuesta> call, Throwable t) {
                aptoParaCargar = true;
                Log.e(TAG, " onFailure: " + t.getMessage());
            }
        });
    }


}