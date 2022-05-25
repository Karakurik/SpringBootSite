package ru.itis.karakurik.site.controller.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.karakurik.site.dto.auth.SignUpForm;
import ru.itis.karakurik.site.service.user.interfaces.UserService;
import ru.itis.karakurik.site.service.validation.interfaces.ValidationService;

import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
public class SignUpController {

    private final UserService userService;

    private final ValidationService validationService;

    @GetMapping(value = "/signUp")
    public String getSignUpPage() {
        return "registration/signUp";
    }

    @PostMapping(value = "/signUp")
    public String signUp(@Valid SignUpForm form, BindingResult bindingResult, ModelMap map) {
        if (bindingResult.hasErrors()) {
            setFields(form, map);
            map.put("message", validationService.getErrors(bindingResult));
            return "registration/signUp";
        } else {
            try {
                userService.signUp(form);
                return "redirect:/login";
            } catch (Exception ex) {
                map.put("message", ex.getMessage());
                setFields(form, map);
                return "registration/signUp";
            }
        }
    }

    public static void setFields(SignUpForm form, ModelMap map) {
        map.put("first_name", form.getFirstName());
        map.put("last_name", form.getLastName());
        map.put("email", form.getEmail());
    }
}
