package ru.itis.karakurik.site.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.karakurik.site.dto.LoginForm;
import ru.itis.karakurik.site.service.UserService;

import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
public class LoginController {

    private final UserService userService;

    @GetMapping(value = "/login")
    public String getLoginPage() {
        return "registration/login";
    }

    @PostMapping(value = "/login")
    public String login(@Valid LoginForm form) {
        userService.login(form);
        return "redirect:/";
    }
}
