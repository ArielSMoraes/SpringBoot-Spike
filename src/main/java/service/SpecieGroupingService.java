package service;

import model.Person;

import java.util.ArrayList;
import java.util.HashMap;

public class SpecieGroupingService {

    private HashMap<String, ArrayList<Person>> species = new HashMap<>();
    private final ApiStarWars personService;

    public SpecieGroupingService(ApiStarWars personService) {
        this.personService = personService;
    }

    public HashMap<String, ArrayList<Person>> groupBySpecies(String people) {

        String[] idPeople = people.split(",");

        for (String personId : idPeople) {
            Person person = personService.getPerson(personId);
            addPersonToSpecieGroup(person);
        }

        return species;
    }

    private void addPersonToSpecieGroup(Person person) {
        if(species.containsKey(person.getSpecieId())){
            addToExistingSpecie(person);
        } else {
            addToNewSpecie(person);
        }
    }

    private void addToNewSpecie(Person person) {
        ArrayList<Person> peopleList = new ArrayList<Person>();
        peopleList.add(person);
        species.put(person.getSpecieId(), peopleList);
    }

    private void addToExistingSpecie(Person person) {
        ArrayList<Person> peopleList;
        peopleList = species.get(person.getSpecieId());
        peopleList.add(person);
    }

}
