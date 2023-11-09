package com.example.pokedex911;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("pokemon")
    Call<List<Pokemon>> getPokemons();

}
