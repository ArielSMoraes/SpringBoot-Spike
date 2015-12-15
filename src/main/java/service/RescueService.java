package service;

import model.Person;

import java.util.ArrayList;
import java.util.HashMap;

public class RescueService{

    private HashMap<String, ArrayList> species = new HashMap<String, ArrayList>();
    private final PersonService personService;

    public RescueService(PersonService personService) {
        this.personService = personService;
    }

    public HashMap<String, ArrayList> groupBySpecies(String people) {

        String[] idPeople = people.split(",");

        for (String personId : idPeople) {
            Person person = personService.get(personId);

            if(species.containsKey(person.getSpecieId())){
                ArrayList<Person> peopleList;
                peopleList = species.get(person.getSpecieId());
                peopleList.add(person);
            } else {
                ArrayList<Person> peopleList = new ArrayList<Person>();
                peopleList.add(person);
                species.put(person.getSpecieId(), peopleList);
            }
            System.out.println(person.getSpecieId());
        }

        return species;
    }

}
