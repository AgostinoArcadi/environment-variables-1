package com.example.environmentvariables1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/basic")
public class BasicController {

    @Autowired
    private Environment environment;

    @GetMapping
    public ResponseEntity<String> nameCode() {
        String code = environment.getProperty("customVars.authCode");
        String name = environment.getProperty("customVars.devName");

        return ResponseEntity.ok().body("Hello " + name + ", authCode: " + code);
    }
}
