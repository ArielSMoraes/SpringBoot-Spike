package service;

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
                e -> (int) Math.round(((double)e.getValue().size() / Integer.parseInt(ship.getPassengers())))
        ).sum();

        return travels;
    }
}
