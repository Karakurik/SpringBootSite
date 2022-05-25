package ru.itis.karakurik.site.controller.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorsController {

    @GetMapping("/accessDenied")
    public String _403() {
        return "exception/access_denied";
    }
}
