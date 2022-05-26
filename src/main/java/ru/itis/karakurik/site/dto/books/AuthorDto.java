package ru.itis.karakurik.site.dto.books;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.karakurik.site.model.books.Author;
import ru.itis.karakurik.site.model.books.Book;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthorDto {
    private Long id;
    private String name;
    private List<Book> books;

    public static AuthorDto from(Author author) {
        return AuthorDto.builder()
                .id(author.getId())
                .name(author.getName())
                .build();
    }
}
