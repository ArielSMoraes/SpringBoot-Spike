package service;

import model.GroupSpecies;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class RescueServiceTest {

    @Test
    public void testPeopleGroupingBySpecies() throws Exception {
        RescueService rescueService = new RescueService();

        ArrayList<GroupSpecies> groupSpicies = rescueService.groupBySpecies("1,42,5,5,1,45,33,50,55,66,67,68,80");

        assertThat(groupSpicies.size(), is(7));
    }

    @Test
    public void testGroupThreeHumans() throws Exception {
        RescueService rescueService = new RescueService();

        ArrayList<GroupSpecies> groupSpecies = rescueService.groupBySpecies("1,4,5");

        assertThat(groupSpecies.get(0).getPeople().size(), is(3));
    }
}