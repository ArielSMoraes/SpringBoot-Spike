package service;


import model.Ship;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

public class ShipService {
    private String baseUrlPerson;

    public ShipService() {
        this.baseUrlPerson = "http://swapi.co/api/vehicles/";
    }

    public Ship get(String id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setMessageConverters(restTemplate.getMessageConverters());
        HttpHeaders headers = new HttpHeaders();
        headers.set("User-Agent", "Mozilla/5.0");
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        return restTemplate.exchange(getUrl(id), HttpMethod.GET, entity, Ship.class).getBody();
    }

    private String getUrl(String id) {
        return this.baseUrlPerson + id + '/';
    }

}
