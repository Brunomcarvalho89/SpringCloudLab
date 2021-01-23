package com.cloud.mss.infrastructure.api.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author bruno
 */
@RestController
@RequestMapping("/message")
public class SubjectController {

    @Value("${subject}")
    private String subject;

    @GetMapping("subject")
    public ResponseEntity hello() {
        return ResponseEntity.ok(this.subject);
    }

}
