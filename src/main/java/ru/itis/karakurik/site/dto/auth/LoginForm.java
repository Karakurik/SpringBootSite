package ru.itis.karakurik.site.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginForm {

    @NotBlank(message = "Email не можеть быть пустым")
    private String email;

    @NotBlank(message = "Пароль не может быть пустым")
    private String password;
}
