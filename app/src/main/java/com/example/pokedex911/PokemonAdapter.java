package com.example.pokedex911;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class PokemonAdapter extends RecyclerView.Adapter<PokemonViewHolder> {
    private List<Pokemon> pokemons;
    private Context context;

    public PokemonAdapter(List<Pokemon> pokemons, Context context) {
        this.pokemons = pokemons;
        this.context = context;
    }

    @Override
    public PokemonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pokemon_item, parent, false);
        return new PokemonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PokemonViewHolder holder, int position) {
        Pokemon pokemon = pokemons.get(position);
        holder.pokemonName.setText(pokemon.getName());
        Glide.with(context).load(pokemon.getImageUrl()).into(holder.pokemonImage);

        holder.itemView.setOnClickListener(v -> {
            // Abrir PokemonDetalleActivity
        });
    }

    @Override
    public int getItemCount() {
        return pokemons.size();
    }
}
