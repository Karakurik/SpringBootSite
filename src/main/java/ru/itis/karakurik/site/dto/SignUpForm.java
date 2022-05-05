package ru.itis.karakurik.site.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.karakurik.site.validation.validators.EqualPasswords;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualPasswords(password = "password", passwordRepeat = "passwordRepeat")
public class SignUpForm {

    @NotBlank(message = "Имя пользователя не может быть пустым")
    private String username;

    @NotBlank(message = "Email  не может быть пустым")
    @Email
    private String email;

    @NotBlank(message = "Имя не может быть пустым")
    private String firstName;

    @NotBlank(message = "Фамилия не может быть пустым")
    private String lastName;

    @NotBlank(message = "Пароль не может быть пустым")
    private String password;

    @NotBlank(message = "Повтор пароля не может быть пустым")
    private String passwordRepeat;
}
