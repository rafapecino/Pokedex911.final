package com.example.pokedex911;

import java.util.ArrayList;

public class PokemonRespuesta {
    private ArrayList<Pokemon> results;
    private ArrayList<Tipo> results2;


    public ArrayList<Pokemon> getResults() {
        return results;
    }
    public ArrayList<Tipo> getResults2() {
        return results2;
    }
    public void setResults(ArrayList<Pokemon> results) {
        this.results = results;
    }
    public void setResults2(ArrayList<Tipo> results2) {
        this.results2 = results2;
    }
}
