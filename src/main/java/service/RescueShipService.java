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

    public Integer normalRescue(HashMap<String, ArrayList> peopleToRescue) {
        int travels = peopleToRescue.entrySet().stream().mapToInt(
                e -> (int) Math.round(((double)e.getValue().size() / Integer.parseInt(ship.getPassengers())) + 0.4d)
        ).sum();

        return travels;
    }

    public Integer rescueOldOnes(HashMap<String, ArrayList> peopleToRescue) {
        ArrayList oldOnesToRescue = new ArrayList<Person>();

        for (String key : peopleToRescue.keySet()){
            ArrayList peopleList = peopleToRescue.get(key);

            float oldest = 0;
            int indexOldest = 0;

            for (int i = 0; i < peopleList.size(); i++) {
                Person person = (Person) peopleList.get(i);
                if(person.getBirth_year() > oldest){
                    oldest = person.getBirth_year();
                    indexOldest = i;
                }
            }

            oldOnesToRescue.add(peopleList.get(indexOldest));
            peopleList.remove(indexOldest);
        }

        HashMap<String, ArrayList> oldOnes = new HashMap<>();
        oldOnes.put("1", oldOnesToRescue);
        return normalRescue(oldOnes);
    }
}
