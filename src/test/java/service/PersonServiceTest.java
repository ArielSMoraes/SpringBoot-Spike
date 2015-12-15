package service;

import model.Person;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class PersonServiceTest {
    
    @Test
    public void testCreateOnePerson() throws Exception {
        PersonService personService = new PersonService();

        Person person = personService.get("1");

        assertThat(person.getSpecieId(), is("1"));
    }

    @Test
    public void testCreateOneDroid() throws Exception {
        PersonService personService = new PersonService();

        Person person = personService.get("2");

        assertThat(person.getSpecieId(), is("2"));
    }

    @Test
    public void testCreateOneWookiee() throws Exception {
        PersonService personService = new PersonService();

        Person person = personService.get("13");

        assertThat(person.getSpecieId(), is("3"));
    }

    @Test
    public void testCreateOnePersonWithMass77() throws Exception {
        PersonService personService = new PersonService();

        Person person = personService.get("1");
        assertThat(person.getMass(), is("77"));
    }

    @Test
    public void testCreatePersonWithoutSpecie() throws Exception {
        PersonService personService = new PersonService();

        Person person = personService.get("42");

        assertThat(person.getSpecieId(), is("unknown"));
    }

    @Test
    public void testCreatePersonWithSpecieTypeHavingTwoNumber() throws Exception {
        PersonService personService = new PersonService();

        Person person = personService.get("33");

        assertThat(person.getSpecieId(), is("11"));
    }
}
