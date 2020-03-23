package com.hamidsultanzadeh.helloworld.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldApi {

    @GetMapping("/hello/{name}")
    public ResponseEntity<String> getName(@PathVariable String name){
        return ResponseEntity.ok("Hello, "+name);
    }

}
