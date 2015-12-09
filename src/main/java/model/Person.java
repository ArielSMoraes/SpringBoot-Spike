package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.awt.*;
import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {
    private Integer mass;
    private String specieId;
    private ArrayList<String> species;

    public Person() {
    }

    public String getSpecieId() {
        String stringSpecies = species.get(0);
        return stringSpecies.substring(stringSpecies.length() -2, stringSpecies.length() -1);
    }

    public Integer getMass() {
        return mass;
    }

    public void setMass(Integer mass) {
        this.mass = mass;
    }

    public ArrayList getSpecies() {
        return species;
    }

    public void setSpecies(ArrayList species) {
        this.species = species;
    }
}
