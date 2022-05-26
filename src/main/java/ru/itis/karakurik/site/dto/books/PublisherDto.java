package ru.itis.karakurik.site.dto.books;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.karakurik.site.model.books.Publisher;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PublisherDto {
    private Long id;
    private String name;

    public static PublisherDto from(Publisher publisher) {
        return PublisherDto.builder()
                .id(publisher.getId())
                .name(publisher.getName())
                .build();
    }
}
