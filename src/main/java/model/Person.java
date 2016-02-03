package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {
    private String mass;
    private String birth_year;
    private String specieId;
    private ArrayList<String> species;

    public Person() {
    }

    public String getSpecieId() {
        if(species.isEmpty()){
            return "unknown";
        }
        String stringSpecie = species.get(0);
        return getIdSpecie(stringSpecie);
    }

    private String getIdSpecie(String stringSpecies) {
        String[] splitUrlSpecie = stringSpecies.split("/");
        String id = splitUrlSpecie[splitUrlSpecie.length-1];
        return id;
    }

    public String getMass() {
        return mass;
    }

    public void setMass(String mass) {
        this.mass = mass;
    }

    public ArrayList getSpecies() {
        return species;
    }

    public void setSpecies(ArrayList species) {
        this.species = species;
    }

    public float getBirth_year() {
        if (birth_year.equals("unknown")){
            birth_year = "0BBY";
        }
        return Float.parseFloat(birth_year.substring(0, birth_year.length() - 3));
    }

    public void setBirth_year(String birth_year) {
        this.birth_year = birth_year;
    }
}
