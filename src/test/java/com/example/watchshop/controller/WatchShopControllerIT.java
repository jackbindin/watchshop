package com.example.watchshop.controller;

import java.util.ArrayList;

import com.example.watchshop.WatchshopApplication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;


@SpringBootTest(classes = WatchshopApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WatchShopControllerIT {
    @LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();

    HttpHeaders headers = new HttpHeaders();

    @Test
    public void testCheckout() {

        ArrayList<String> watches = new ArrayList<>();
        watches.add("1");
        watches.add("1");
        watches.add("2");
        watches.add("4");
        watches.add("1");
        watches.add("1");
        watches.add("1");
        watches.add("2");
        watches.add("1");
        watches.add("1");
        watches.add("3");
        watches.add("3");

        HttpEntity<ArrayList<String>> entity = new HttpEntity<>(watches, headers);

        ResponseEntity<Double> response = restTemplate.exchange(
                createURLWithPort("/checkout"),
                HttpMethod.POST, entity, Double.class);

        Double actual = response.getBody();

        Assertions.assertEquals(750, actual);

    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}
