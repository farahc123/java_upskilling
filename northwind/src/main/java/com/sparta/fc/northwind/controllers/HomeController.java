package com.sparta.fc.northwind.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class HomeController {
    @GetMapping("/")
    public ResponseEntity<Void> redirectToSwaggerUI() // redirect works because we're adding the below location header
    {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "swagger-ui/index.html");
        return ResponseEntity.status(HttpStatus.FOUND).headers(headers).build();
    }


}
