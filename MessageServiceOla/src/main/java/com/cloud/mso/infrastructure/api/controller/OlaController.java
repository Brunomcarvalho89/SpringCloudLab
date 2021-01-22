package com.cloud.mso.infrastructure.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author bruno
 */
@RestController
@RequestMapping("/message")
public class OlaController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public ResponseEntity hello() {
        String subject = this.restTemplate.getForObject("http://message-service-subject/message/subject", String.class);
        return ResponseEntity.ok(String.format("Olá %s !!!", subject));
    }

}
