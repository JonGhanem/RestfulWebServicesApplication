package com.ghanem.RestfulWebServicesApplication.helloworld.controller;

import com.ghanem.RestfulWebServicesApplication.helloworld.bean.HelloWorldBean;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorldController {
    MessageSource messageSource;

    public HelloWorldController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping(path = "/v1/hello-word")
    public String helloWorld(){
         return "Hello World!";
     }

    @GetMapping(path = "/v1/hello-word-inter")
    public String helloWorldInternationalized(){
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message", null, "Default Message", locale );
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
