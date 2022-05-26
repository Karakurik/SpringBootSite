package ru.itis.karakurik.site.controller.oauth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.karakurik.site.aspects.logging.Logger;

@Controller
class GoogleOAuth2Controller {

    @Logger
    @GetMapping("/oauth/google")
    public String googleOAuth2() {
        return "redirect:/books";
    }
}
