package ru.itis.karakurik.site.dto.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewPasswordForm {

    @NotBlank(message = "Token не можеть быть пустым")
    private String token;

    @NotBlank(message = "Пароль не может быть пустым")
    private String password;
}
