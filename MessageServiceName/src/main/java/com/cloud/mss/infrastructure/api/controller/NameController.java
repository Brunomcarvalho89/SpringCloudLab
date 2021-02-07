package com.cloud.mss.infrastructure.api.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author brunomcarvalho89@gmail.com
 */
@RestController
@RequestMapping("/message")
public class NameController {

    @Value("${name}")
    private String name;

    @GetMapping("/name")
    public ResponseEntity hello() {
        return ResponseEntity.ok(this.name);
    }

}
