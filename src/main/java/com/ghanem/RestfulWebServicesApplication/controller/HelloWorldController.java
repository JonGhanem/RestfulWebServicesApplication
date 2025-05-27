package com.ghanem.RestfulWebServicesApplication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping(path = "/v1/hello-word")
    public String helloWorld(){
         return "Hello World!";
     }
}
