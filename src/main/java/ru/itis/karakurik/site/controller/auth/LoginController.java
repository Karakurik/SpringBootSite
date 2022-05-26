package ru.itis.karakurik.site.controller.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.karakurik.site.aspects.logging.Logger;
import ru.itis.karakurik.site.dto.auth.LoginForm;
import ru.itis.karakurik.site.service.user.interfaces.UserService;

import javax.validation.Valid;

import static ru.itis.karakurik.site.model.user.Role.ROLE_ADMIN;

@RequiredArgsConstructor
@Controller
public class LoginController {

    private final UserService userService;

    @Logger
    @GetMapping(value = "/login")
    public String getLoginPage() {
        return "registration/login";
    }

    @Logger
    @PostMapping(value = "/login")
    public String login(
            @Valid LoginForm form,
            @AuthenticationPrincipal UserDetails userDetails
    ) {
        userService.login(form);
        if (userDetails.getAuthorities().contains(new SimpleGrantedAuthority(ROLE_ADMIN.name()))) {
            return "redirect:/admin";
        } else {
            return "redirect:/books";
        }
    }
}
