package org.example.model.entities;

import lombok.Data;

@Data
public class Country {
    private int id;
    private String name;
    private String capital;
    private String president;
    private int population;

    public Country(int id, String name, String capital, String president, int population) {
        this.id = id;
        this.name = name;
        this.capital = capital;
        this.president = president;
        this.population = population;
    }

    public Country(String name, String capital, String president, int population) {
        this.name = name;
        this.capital = capital;
        this.president = president;
        this.population = population;
    }
}
