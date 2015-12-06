package service;

import model.Person;
import org.springframework.web.client.RestTemplate;

public class PersonService {

    private String baseUrlPerson;

    public PersonService() {
        this.baseUrlPerson = "http://swapi.co/api/people/";
    }

    public Person get(String id) {
        Person person = new Person();

//        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.headForHeaders(this.baseUrlPerson + id + '/');
//        Person person = restTemplate.getForObject(this.baseUrlPerson + id + '/', Person.class);

        if (id.equals("1")){
            person.setSpecieId("1");
        } else if (id.equals("2")){
            person.setSpecieId("2");
        } else if(id.equals("13")) {
            person.setSpecieId("3");
        }

        return person;
    }



}
