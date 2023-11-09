package com.example.pokedex911;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class PokemonViewHolder extends RecyclerView.ViewHolder {
    ImageView pokemonImage;
    TextView pokemonName;
    ImageView favoriteIcon;

    public PokemonViewHolder(View itemView) {
        super(itemView);
        pokemonImage = itemView.findViewById(R.id.pokemonImage);
        pokemonName = itemView.findViewById(R.id.pokemonName);
        favoriteIcon = itemView.findViewById(R.id.favoriteIcon);

        favoriteIcon.setOnClickListener(v -> {
            // Guardar o eliminar elemento
        });
    }
}
