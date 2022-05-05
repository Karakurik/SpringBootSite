package ru.itis.karakurik.site.dto;

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

    @NotBlank(message = "Имя пользователя или email не можеть быть пустым")
    private String usernameOrEmail;

    @NotBlank(message = "Пароль не может быть пустым")
    private String password;
}
