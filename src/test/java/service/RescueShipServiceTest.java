package service;

import model.Person;
import model.Ship;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.is;

public class RescueShipServiceTest {

    private PersonService personService;
    private Ship ship;
    private ShipService shipService;
    private HashMap<String, ArrayList<Person>> peopleToRescue;
    private SpecieGroupingService specieGroupingService;

    @Before
    public void setUp() throws Exception {
        personService = new PersonService();
        shipService = new ShipService();
        specieGroupingService = new SpecieGroupingService(personService);
    }

    @Test
    public void testOneTravelForFourHumans() throws Exception {
        ship = shipService.get("72");
        peopleToRescue = specieGroupingService.groupBySpecies("1,1,1,1");
        RescueShipService rescueShip = new RescueShipService(ship);

        Integer countRescueTravels = rescueShip.normalRescue(peopleToRescue);

        assertThat(countRescueTravels, is(1));
    }

    @Test
    public void testOnlyTwoTravelsForTwoKindsOfSpicies() throws Exception {
        ship = shipService.get("72");
        peopleToRescue = specieGroupingService.groupBySpecies("1,1,1,1,55,55,55,55");
        RescueShipService rescueShip = new RescueShipService(ship);

        Integer countRescueTravels = rescueShip.normalRescue(peopleToRescue);

        assertThat(countRescueTravels, is(2));
    }

    @Test
    public void testThreeTravelsForElevenHumans() throws Exception {
        ship = shipService.get("72");
        peopleToRescue = specieGroupingService.groupBySpecies("1,1,1,1,1,1,1,1,1");
        RescueShipService rescueShip = new RescueShipService(ship);

        Integer countRescueTravels = rescueShip.normalRescue(peopleToRescue);

        assertThat(countRescueTravels, is(3));
    }

    @Test
    public void testRescueTheOldOnesFirst() throws Exception {
        ship = shipService.get("72");
        peopleToRescue = specieGroupingService.groupBySpecies("1,4,5,6,7");
        RescueShipService rescueShip = new RescueShipService(ship);
        Object removedOldOne = peopleToRescue.get("1").get(3);

        Integer countRescueTravels = rescueShip.rescueOldOnes(peopleToRescue);

        assertThat(countRescueTravels, is(1));
        assertThat(peopleToRescue.get("1").size(), is(4));
        assertThat(peopleToRescue.get("1").contains(removedOldOne), is(false));
    }

    @Test
    public void testRescueOldOneHuman() throws Exception {
        ship = shipService.get("72");
        peopleToRescue = specieGroupingService.groupBySpecies("1,4,5,6,7,32");
        RescueShipService rescueShip = new RescueShipService(ship);
        Object removedOldOne = peopleToRescue.get("1").get(5);

        rescueShip.rescueOldOnes(peopleToRescue);

        assertThat(peopleToRescue.get("1").contains(removedOldOne), is(false));
    }

    @Test
    public void testRescueOldOneOfManySpecies() throws Exception {
        ship = shipService.get("72");
        peopleToRescue = specieGroupingService.groupBySpecies("15,15,16,16,55,55,29,29,31,31,59,59,33,33,40,40,8,8");
        RescueShipService rescueShip = new RescueShipService(ship);

        Integer countRescueTravels = rescueShip.rescueOldOnes(peopleToRescue);

        assertThat(countRescueTravels, is(3));
    }

    @Test
    public void testRescueFourHumansOneHas100MassNeededTwoTravels() throws Exception {
        ship = shipService.get("72");
        peopleToRescue = specieGroupingService.groupBySpecies("1,1,1,4");
        RescueShipService rescueShip = new RescueShipService(ship);

        Integer countRescueTravels = rescueShip.rescueConsideringFats(peopleToRescue);

        assertThat(countRescueTravels, is(2));
    }
}
