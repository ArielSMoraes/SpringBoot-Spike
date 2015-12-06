package model;

import java.util.ArrayList;

public class GroupSpecies {
    private String specieName;
    private ArrayList<String> people = new ArrayList<String>();

    public GroupSpecies(String specieName) {
        this.specieName = specieName;
    }

    public String getSpecieName() {
        return specieName;
    }

    public void setSpecieName(String specieName) {
        this.specieName = specieName;
    }

    public ArrayList<String> getPeople() {
        return people;
    }

    public void setPeople(String person) {
        this.people.add(person);
    }
}