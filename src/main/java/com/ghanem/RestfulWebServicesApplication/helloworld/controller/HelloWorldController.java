package com.ghanem.RestfulWebServicesApplication.helloworld.controller;

import com.ghanem.RestfulWebServicesApplication.helloworld.bean.HelloWorldBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping(path = "/v1/hello-word")
    public String helloWorld(){
         return "Hello World!";
     }

    @GetMapping(path = "/v1/hello-word-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("hello World!");
    }

    @GetMapping(path = "/v1/hello-word-path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello World!, %s ", name));
//        return new HelloWorldBean("hello World!" + name);
    }
}
