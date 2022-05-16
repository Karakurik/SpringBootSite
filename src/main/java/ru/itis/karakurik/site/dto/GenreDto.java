package ru.itis.karakurik.site.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import ru.itis.karakurik.site.model.Genre;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class GenreDto {
    private Long id;
    private String name;

    public static GenreDto from(Genre genre) {
        return GenreDto.builder()
                .id(genre.getId())
                .name(genre.getName())
                .build();
    }
}
