package ru.itis.karakurik.site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.security.PermitAll;

@Controller
public class HelloController {

    @PermitAll
    @GetMapping(value = "/hello")
    public String hello() {
        return "hello/hello";
    }
}
