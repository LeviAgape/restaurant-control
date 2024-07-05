package com.example.restaurant.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/food")
public class RestaurantController {

    @GetMapping
    public ResponseEntity getAll(){
        return ResponseEntity.ok("deu ok");
    }
}

