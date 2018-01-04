package com.stackoverflow.apiclient.resource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;


@RestController("/message")
public class ClientMessageResource {

    @Autowired
    private OAuth2RestTemplate template;


    @Value("${service.url}")
    private String endpoint;

    @GetMapping
    public String getMessageFromService() {


        RequestEntity<Void> request = RequestEntity
                .get(URI.create(endpoint))
                .build();

        ResponseEntity<String> response = template.exchange(request, String.class);
        return response.getBody();

    }
}
