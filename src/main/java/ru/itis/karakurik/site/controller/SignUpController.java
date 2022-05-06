package ru.itis.karakurik.site.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.itis.karakurik.site.dto.SignUpForm;
import ru.itis.karakurik.site.service.UserService;
import ru.itis.karakurik.site.validation.http.ValidationErrorDto;
import ru.itis.karakurik.site.validation.http.ValidationExceptionResponse;

import javax.annotation.security.PermitAll;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class SignUpController {

    private final UserService userService;

    @GetMapping(value = "/signUp")
    public String getSignUpPage() {
        return "registration/signUp";
    }

    @PostMapping(value = "/signUp")
    public String signUp(@Valid SignUpForm form) {
        userService.signUp(form);
        return "redirect:/login";
    }
}
