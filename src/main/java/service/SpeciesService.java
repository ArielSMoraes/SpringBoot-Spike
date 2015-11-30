package service;

import model.Species;

import java.util.ArrayList;

public class SpeciesService {
    private int total;
    private ArrayList species;

    public SpeciesService() {
        species = new ArrayList();
    }

    public int getTotal() {
        return total;
    }

    public ArrayList<Species> getSpecies() {
        return species;
    }
}
