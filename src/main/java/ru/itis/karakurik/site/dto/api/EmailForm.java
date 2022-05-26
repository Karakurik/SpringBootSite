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
public class EmailForm {

    @NotBlank(message = "Email не можеть быть пустым")
    private String email;
}
