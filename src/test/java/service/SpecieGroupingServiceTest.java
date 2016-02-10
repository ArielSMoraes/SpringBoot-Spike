package service;

import model.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SpecieGroupingServiceTest {

    @Test
    public void testGroupOneHumanTwoDroid() throws Exception {
        ApiStarWars personService = new ApiStarWars();
        SpecieGroupingService specieGroupingService = new SpecieGroupingService(personService);

        HashMap<String, ArrayList<Person>> groupSpecies = specieGroupingService.groupBySpecies("1,2,3");

        assertThat(groupSpecies.get("1").size(), is(1));
        assertThat(groupSpecies.get("2").size(), is(2));
    }

    @Test
    public void testGroupThreeHumans() throws Exception {
        ApiStarWars personService = new ApiStarWars();
        SpecieGroupingService specieGroupingService = new SpecieGroupingService(personService);

        HashMap<String, ArrayList<Person>> groupSpecies = specieGroupingService.groupBySpecies("1,4,5");

        assertThat(groupSpecies.get("1").size(), is(3));
    }

    @Test
    public void testPeopleGroupingBySpecies() throws Exception {
        ApiStarWars personService = new ApiStarWars();
        SpecieGroupingService specieGroupingService = new SpecieGroupingService(personService);

        HashMap<String, ArrayList<Person>> groupSpecies = specieGroupingService.groupBySpecies("1,1,5,5,33,42,45,50,55,66,67,68,80");

        assertThat(groupSpecies.size(), is(7));
    }
}