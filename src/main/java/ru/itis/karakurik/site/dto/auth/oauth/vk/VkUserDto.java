package ru.itis.karakurik.site.dto.auth.oauth.vk;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class VkUserDto {
    private Long id;

    @JsonProperty("first_name")
    private String firstNAme;

    @JsonProperty("last_name")
    private String lastName;
}
