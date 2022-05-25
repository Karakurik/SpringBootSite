package ru.itis.karakurik.site.controller.oauth;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VkOauthController {

    @GetMapping("/vk")
    public String loginByVk(
            @Param("code") String code
    ) {
        return "redirect:/books";
    }
}
