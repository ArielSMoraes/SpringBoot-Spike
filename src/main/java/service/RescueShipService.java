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
        return peopleToRescue.entrySet().stream().mapToInt(
                e -> travelCount(e.getValue().size())
        ).sum();
    }

    public Integer rescueConsideringFats(HashMap<String, ArrayList<Person>> peopleToRescue) {
        return peopleToRescue.entrySet().stream().mapToInt(
            e -> travelCount(howManySeatsAreNeeded(e.getValue()))
        ).sum();
    }

    public Integer rescueOnlyWomenConsideringFat(HashMap<String, ArrayList<Person>> peopleToRescue) {
        return peopleToRescue.entrySet().stream()
                .filter(e -> e.getKey().equals("1"))
                .mapToInt(e -> travelCount(howManySeatsAreNeededForWomen(e.getValue()))
        ).sum();
    }

    private int howManySeatsAreNeededForWomen(ArrayList<Person> people) {
        return people.stream()
                .filter(person -> person.getGender().equals("female"))
                .mapToInt(
                        (e) -> {
                            ArrayList<Person> personTemp = new ArrayList<>();
                            personTemp.add(e);
                            return 1 + getFatsSeats(personTemp);
                        }
                )
                .sum();
    }

    private int travelCount(double seatNeeded) {
        return (int) Math.round((seatNeeded / Integer.parseInt(ship.getPassengers())) + 0.4d);
    }

    private int howManySeatsAreNeeded(ArrayList<Person> people) {
        return getFatsSeats(people) + people.size();
    }

    private int getFatsSeats(ArrayList<Person> people) {
        return people.stream()
            .filter(person -> person.getMass().equals("unknown") || Integer.parseInt(person.getMass()) > 100)
            .mapToInt(e -> 1)
            .sum();
    }

    public Integer rescueOldOnes(HashMap<String, ArrayList<Person>> peopleToRescue) {
        ArrayList<Person> oldOnesToRescue = new ArrayList<>();

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
