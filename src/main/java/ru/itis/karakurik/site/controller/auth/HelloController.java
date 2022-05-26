package ru.itis.karakurik.site.controller.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.karakurik.site.aspects.logging.Logger;

@Controller
public class HelloController {

    @Logger
    @GetMapping(value = "/hello")
    public String hello() {
        return "hello/hello";
    }
}
