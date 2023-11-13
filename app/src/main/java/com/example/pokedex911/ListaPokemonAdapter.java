package com.example.pokedex911;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.pokedex911.R;
import com.example.pokedex911.Pokemon;

import java.util.ArrayList;

public class ListaPokemonAdapter extends RecyclerView.Adapter<ListaPokemonAdapter.ViewHolder> {

    private ArrayList<Pokemon> dataset;

    private Context context;

    public ListaPokemonAdapter(Context context) {
        this.context = context;
        this.dataset = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int  viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pokemon,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaPokemonAdapter.ViewHolder holder, int position) {
        final Pokemon p = dataset.get(position);
        holder.nombreTextView.setText(p.getName());
        holder.getItemViewType();


        Glide.with(context).load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"+p.getNumber()+".png")
                .centerCrop().diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.fotoImageView);
        holder.fotoImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //llamada a la api para obtener los datos del pokemon
                Intent intent = new Intent(context, DetallePokemonActivity.class);
                intent.putExtra("pokemon_name", p.getName());
                intent.putExtra("pokmon_image_url", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"+p.getNumber()+".png");
                intent.putExtra("pokemon_type", p.getType());
                context.startActivity(intent);
            }

        });
    }


    @Override
    public int getItemCount(){
        return dataset.size();
    }

    public void adicionarListaPokemon(ArrayList<Pokemon> listaPokemon) {
        dataset.addAll(listaPokemon);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView fotoImageView;
        private TextView nombreTextView;


        public ViewHolder(View itemView){
            super(itemView);

            fotoImageView = itemView.findViewById(R.id.imageView);
            nombreTextView = itemView.findViewById(R.id.textView);
        }
    }
}
