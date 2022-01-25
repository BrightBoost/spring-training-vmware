package com.example.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ExampleRestTemplateController {
    @Autowired
    private RestTemplate restTemplate;

    // calling this api http://dummy.restapiexample.com/api/v1/employee/1
    @GetMapping("resttemplate")
    public String testRestTemplate() {
        String s = "http://dummy.restapiexample.com/api/v1/employee/1";
        return restTemplate.getForObject(s, String.class);
    }

    @GetMapping("resttemplate2")
    public ResponseEntity<String> testRestTemplate2() {
        String s = "http://dummy.restapiexample.com/api/v1/employee/{id}";
        Map<String, String> input = new HashMap<>();
        input.put("id", "2");
        return restTemplate.getForEntity(s, String.class, input);
    }
}
