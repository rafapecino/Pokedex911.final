package com.example.pokedex911;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PokeapiService {

        @GET("pokemon")
        Call<PokemonRespuesta> obtenerListaPokemon(@Query("limit") int limit, @Query("offset") int offset);

        @GET("type")
        Call<PokemonRespuesta> obtenerTipo(@Query("limit") int limit, @Query("offset") int offset);
}
