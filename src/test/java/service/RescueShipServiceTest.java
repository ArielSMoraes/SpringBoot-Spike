package service;

import model.Ship;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class RescueShipServiceTest {

    @Test
    public void testOneTravelForFourHumans() throws Exception {
        PersonService personService = new PersonService();
        ShipService shipService = new ShipService();
        SpecieGroupingService specieGroupingService = new SpecieGroupingService(personService);
        HashMap<String, ArrayList> peopleToRescue = specieGroupingService.groupBySpecies("1,1,1,1");
        Ship ship = shipService.get("72");

        RescueShipService rescueShip = new RescueShipService(ship);
        Integer countRescueTravels = rescueShip.normalRescue(peopleToRescue);

        assertThat(countRescueTravels, is(1));
    }

    @Test
    public void testOnlyTwoTravelsForTwoKindsOfSpicies() throws Exception {
        PersonService personService = new PersonService();
        ShipService shipService = new ShipService();
        SpecieGroupingService specieGroupingService = new SpecieGroupingService(personService);
        HashMap<String, ArrayList> peopleToRescue = specieGroupingService.groupBySpecies("1,1,1,1,55,55,55,55");
        Ship ship = shipService.get("72");

        RescueShipService rescueShip = new RescueShipService(ship);
        Integer countRescueTravels = rescueShip.normalRescue(peopleToRescue);

        assertThat(countRescueTravels, is(2));
    }

    @Test
    public void testThreeTravelsForElevenHumans() throws Exception {
        PersonService personService = new PersonService();
        ShipService shipService = new ShipService();
        SpecieGroupingService specieGroupingService = new SpecieGroupingService(personService);
        HashMap<String, ArrayList> peopleToRescue = specieGroupingService.groupBySpecies("1,1,1,1,1,1,1,1,1,1,1");
        Ship ship = shipService.get("72");

        RescueShipService rescueShip = new RescueShipService(ship);
        Integer countRescueTravels = rescueShip.normalRescue(peopleToRescue);

        assertThat(countRescueTravels, is(3));
    }

    @Test
    public void testRescueTheOldOnes() throws Exception {
        PersonService personService = new PersonService();
        ShipService shipService = new ShipService();
        SpecieGroupingService specieGroupingService = new SpecieGroupingService(personService);
        HashMap<String, ArrayList> peopleToRescue = specieGroupingService.groupBySpecies("1,4,5,6,7");
        Ship ship = shipService.get("72");

        RescueShipService rescueShip = new RescueShipService(ship);
        Integer countRescueTravels = rescueShip.normalRescue(peopleToRescue);

        assertThat(countRescueTravels, is(1));
    }
}
