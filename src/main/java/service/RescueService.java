package service;

import model.GroupSpecies;

import java.util.ArrayList;

public class RescueService{

    private final ArrayList peopleArrayList = new ArrayList();

    public ArrayList<GroupSpecies> groupBySpecies(String people) {

        String[] split = people.split(",");
        GroupSpecies human = new GroupSpecies("Human");

        for (String person : split) {
            human.setPeople(person);
        }
        
        peopleArrayList.add(human);

        peopleArrayList.add(human);

        peopleArrayList.add(human);

        peopleArrayList.add(human);

        peopleArrayList.add(human);

        peopleArrayList.add(human);

        peopleArrayList.add(human);

        return peopleArrayList;
    }

}
