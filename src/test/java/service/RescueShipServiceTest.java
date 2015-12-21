package service;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class RescueShipServiceTest {

    @Test
    public void testOneTravelForFourHumans() throws Exception {
        PersonService personService = new PersonService();
        SpecieGroupingService specieGroupingService = new SpecieGroupingService(personService);
        HashMap<String, ArrayList> peopleToRescue = specieGroupingService.groupBySpecies("1,1,1,1");

        RescueShipService rescueShip = new RescueShipService(72);
        Integer countRescueTravels = rescueShip.normalRescue(peopleToRescue);

        assertThat(countRescueTravels, is(1));
    }

    @Test
    public void testOnlyTwoTravelsForEightHumans() throws Exception {
        PersonService personService = new PersonService();
        SpecieGroupingService specieGroupingService = new SpecieGroupingService(personService);
        HashMap<String, ArrayList> peopleToRescue = specieGroupingService.groupBySpecies("1,1,1,1,4,4,4,4");

        RescueShipService rescueShip = new RescueShipService(72);
        Integer countRescueTravels = rescueShip.normalRescue(peopleToRescue);

        assertThat(countRescueTravels, is(2));
    }
}
