package ru.itis.karakurik.site.controller.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.karakurik.site.aspects.logging.Logger;
import ru.itis.karakurik.site.dto.api.EmailForm;
import ru.itis.karakurik.site.dto.api.NewPasswordForm;
import ru.itis.karakurik.site.service.api.ApiService;
import ru.itis.karakurik.site.service.user.interfaces.UserService;
import ru.itis.karakurik.site.service.validation.interfaces.ValidationService;

import javax.validation.Valid;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class ChangePasswordController {

    private final ApiService apiService;
    private final ValidationService validationService;
    private final UserService userService;

    @Logger
    @GetMapping("/resetPassword")
    public String getBookInfo() {
        return "registration/reset_password";
    }

    @Logger
    @PostMapping(value = "/resetPassword")
    public String resetPassword(@Valid EmailForm form, BindingResult bindingResult, ModelMap map) {
        if (bindingResult.hasErrors()) {
            map.put("message", validationService.getErrors(bindingResult));
            return "registration/signUp";
        } else {
            try {
                if (userService.getUserByEmail(form.getEmail()) != null) {
                    String token = UUID.randomUUID().toString();
                    apiService.sendSms(form.getEmail(), token);
                    apiService.saveToken(form.getEmail(), token);
                } else {
                    map.put("message", "email не зарегистрирован");
                    return "registration/reset_password";
                }
                return "registration/reset_password_after";
            } catch (Exception ex) {
                map.put("message", ex.getMessage());
                return "registration/reset_password";
            }
        }
    }

    @Logger
    @GetMapping("/changePassword")
    public String changePassword(@RequestParam("token") String token, ModelMap modelMap) {
        modelMap.addAttribute("token", token);
        return "registration/change_password";
    }

    @Logger
    @PostMapping("/changePassword")
    public String changePassword(@Valid NewPasswordForm newPasswordForm, BindingResult bindingResult, ModelMap map) {
        if (bindingResult.hasErrors()) {
            map.put("message", validationService.getErrors(bindingResult));
            return "registration/reset_password_after";
        } else {
            try {
                String email = apiService.getEmailByToken(newPasswordForm.getToken());
                String newPassword = newPasswordForm.getPassword();
                userService.changePassword(email, newPassword);
                return "redirect:/login";
            } catch (Exception ex) {
                map.put("message", ex.getMessage());
                return "registration/change_password";
            }
        }
    }
}
