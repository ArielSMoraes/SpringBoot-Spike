package service;

import model.Person;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class PersonServiceTest {
    
    @Test
    public void testCreateOnePerson() throws Exception {
        ApiStarWars apiStarWars = new ApiStarWars();

        Person person = apiStarWars.getPerson("1");

        assertThat(person.getSpecieId(), is("1"));
    }

    @Test
    public void testCreateOneDroid() throws Exception {
        ApiStarWars apiStarWars = new ApiStarWars();

        Person person = apiStarWars.getPerson("2");

        assertThat(person.getSpecieId(), is("2"));
    }

    @Test
    public void testCreateOneWookiee() throws Exception {
        ApiStarWars apiStarWars = new ApiStarWars();

        Person person = apiStarWars.getPerson("13");

        assertThat(person.getSpecieId(), is("3"));
    }

    @Test
    public void testCreateOnePersonWithMass77() throws Exception {
        ApiStarWars apiStarWars = new ApiStarWars();

        Person person = apiStarWars.getPerson("1");
        assertThat(person.getMass(), is("77"));
    }

    @Test
    public void testCreatePersonWithoutSpecie() throws Exception {
        ApiStarWars apiStarWars = new ApiStarWars();

        Person person = apiStarWars.getPerson("42");

        assertThat(person.getSpecieId(), is("unknown"));
    }

    @Test
    public void testCreatePersonWithSpecieTypeHavingTwoNumber() throws Exception {
        ApiStarWars apiStarWars = new ApiStarWars();

        Person person = apiStarWars.getPerson("33");

        assertThat(person.getSpecieId(), is("11"));
    }
}
