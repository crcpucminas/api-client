package com.stackoverflow.apiclient.resource;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;


@RestController("/message")
public class ClientMessageResource {


    private RestTemplate restTemplate;

    @Value("${service.url}")
    private String endpoint;

    @GetMapping
    public String getMessageFromService() {

        this.restTemplate = new RestTemplate();

        RequestEntity<Void> request = RequestEntity
                .get(URI.create(endpoint))
                .build();

        ResponseEntity<String> response = restTemplate.exchange(request, String.class);
        return response.getBody();

    }
}
