package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.SimplePojo;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() throws JsonProcessingException {
        SimplePojo simplePojo = new SimplePojo();
        simplePojo.setId(10);
        simplePojo.setName("my name");

        ObjectMapper mapper = new ObjectMapper();

        return mapper.writeValueAsString(simplePojo);
    }

}