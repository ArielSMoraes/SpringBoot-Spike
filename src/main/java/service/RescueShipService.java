package service;

import model.Person;
import model.Ship;

import java.util.ArrayList;
import java.util.HashMap;

public class RescueShipService {
    private Ship ship;

    public RescueShipService(Ship ship) {
        this.ship = ship;
    }

    public Integer normalRescue(HashMap<String, ArrayList<Person>> peopleToRescue) {
        int travels = peopleToRescue.entrySet().stream().mapToInt(
                e -> (int) Math.round(((double)e.getValue().size() / Integer.parseInt(ship.getPassengers())) + 0.4d)
        ).sum();

        return travels;
    }

    public Integer rescueConsideringFats(HashMap<String, ArrayList<Person>> peopleToRescue) {
        int travels = peopleToRescue.entrySet().stream().mapToInt(
            e -> {
                int seatNeeded = howManySeatsAreNeeded(e.getValue());
                return (int) Math.round(((double) seatNeeded / Integer.parseInt(ship.getPassengers())) + 0.4d);
            }
        ).sum();

        return travels;
    }

    private int howManySeatsAreNeeded(ArrayList<Person> people) {
        int countFats = people.stream()
            .filter(person -> Integer.parseInt(person.getMass()) > 100)
            .mapToInt(e -> 1)
            .sum();
        return countFats + people.size();
    }

    public Integer rescueOldOnes(HashMap<String, ArrayList<Person>> peopleToRescue) {
        ArrayList<Person> oldOnesToRescue = new ArrayList<Person>();

        for (String key : peopleToRescue.keySet()){
            ArrayList<Person> peopleList = peopleToRescue.get(key);

            float oldest = 0;
            int indexOldest = 0;

            for (int i = 0; i < peopleList.size(); i++) {
                Person person = peopleList.get(i);
                if(person.getBirth_year() > oldest){
                    oldest = person.getBirth_year();
                    indexOldest = i;
                }
            }

            oldOnesToRescue.add(peopleList.get(indexOldest));
            peopleList.remove(indexOldest);
        }

        HashMap<String, ArrayList<Person>> oldOnes = new HashMap<>();
        oldOnes.put("1", oldOnesToRescue);
        return normalRescue(oldOnes);
    }
}
