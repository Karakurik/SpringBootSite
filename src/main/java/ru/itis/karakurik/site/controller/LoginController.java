package ru.itis.karakurik.site.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.itis.karakurik.site.dto.LoginForm;
import ru.itis.karakurik.site.service.UserService;

import javax.validation.Valid;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/login")
    public String getLoginPage() {
        return "registration/login";
    }

    @PostMapping(value = "/login")
    public String login(@Valid @RequestBody LoginForm form) {
        userService.login(form);
        return "redirect:/";
    }
}
