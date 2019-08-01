package com.homework.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @GetMapping
    public ResponseEntity<Map<String, String>> greeting() {
        Map<String, String> resMap = new HashMap<>();
        resMap.put("message", "Hello world!!!");
        return new ResponseEntity<>(resMap, HttpStatus.OK);
    }
}
