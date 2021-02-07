package com.cloud.mso.infrastructure.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author brunomcarvalho89@gmail.com
 */
@RestController
@RequestMapping("/message")
@RefreshScope
public class OlaController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${description.service}")
    private String descriptionLanguageService;

    @Autowired
    private CircuitBreakerFactory circuitBreakerFactory;

    @GetMapping
    public ResponseEntity hello() {

        return circuitBreakerFactory.create("helloFallback").run(() -> {
            String subject = this.restTemplate.getForObject("http://message-service-name/message/name", String.class);
            return ResponseEntity.ok(String.format("[%s] Olá %s !!!", this.descriptionLanguageService, subject));
        }, t -> {
            return ResponseEntity.ok("Olá.");
        });
    }

}
