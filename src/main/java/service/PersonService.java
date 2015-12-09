package service;

import model.Person;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

public class PersonService {

    private String baseUrlPerson;

    public PersonService() {
        this.baseUrlPerson = "http://swapi.co/api/people/";
    }

    public Person get(String id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setMessageConverters(restTemplate.getMessageConverters());
        HttpHeaders headers = new HttpHeaders();
        headers.set("User-Agent", "Mozilla/5.0");
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        return restTemplate.exchange(getUrl(id), HttpMethod.GET, entity, Person.class).getBody();
    }

    private String getUrl(String id) {
        return this.baseUrlPerson + id + '/';
    }

}
