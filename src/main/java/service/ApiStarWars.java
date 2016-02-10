package service;

import model.Person;
import model.Ship;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

public class ApiStarWars {

    private final String baseUrlShip;
    private final String baseUrlPerson;
    private RestTemplate restTemplate;
    private HttpHeaders headers;
    private HttpEntity<String> entity;

    public ApiStarWars() {
        restTemplate = new RestTemplate();
        headers = new HttpHeaders();
        baseUrlPerson = "http://swapi.co/api/people/";
        baseUrlShip = "http://swapi.co/api/vehicles/";
    }

    public Person getPerson(String id) {
        setHeaders();
        return getBodyPerson(id, entity);
    }

    public Ship getShip(String id) {
        setHeaders();
        return getBodyShip(id, entity);
    }

    private Person getBodyPerson(String id, HttpEntity<String> entity) {
        return restTemplate.exchange(getUrl(id, baseUrlPerson), HttpMethod.GET, entity, Person.class).getBody();
    }

    private Ship getBodyShip(String id, HttpEntity<String> entity) {
        return restTemplate.exchange(getUrl(id, baseUrlShip), HttpMethod.GET, entity, Ship.class).getBody();
    }

    private void setHeaders() {
        restTemplate.setMessageConverters(restTemplate.getMessageConverters());
        headers.set("User-Agent", "Mozilla/5.0");
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        entity = new HttpEntity<String>(headers);
    }

    private String getUrl(String id, String url) {
        return url + id + '/';
    }
}
