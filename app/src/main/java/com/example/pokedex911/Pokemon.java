package com.example.pokedex911;


public class Pokemon {
    private int number;
    private String name;
    private String type;
    private String weight;
    private String height;



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getNumber() {
        String[] urlParts = url.split("/");
        return Integer.parseInt(urlParts[urlParts.length-1]);
    }

    public void setNumber(int number) {
        this.number = number;
    }
}

