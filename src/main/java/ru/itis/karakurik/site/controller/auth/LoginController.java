package ru.itis.karakurik.site.controller.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.karakurik.site.dto.auth.LoginForm;
import ru.itis.karakurik.site.model.user.Role;
import ru.itis.karakurik.site.service.user.interfaces.UserService;

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
    public String login(@Valid LoginForm form, @AuthenticationPrincipal UserDetails userDetails) {
        userService.login(form);
        if (userDetails.getAuthorities().contains(new SimpleGrantedAuthority(Role.ROLE_ADMIN.name()))) {
            return "redirect:/admin";
        } else {
            return "redirect:/books";
        }
    }
}
