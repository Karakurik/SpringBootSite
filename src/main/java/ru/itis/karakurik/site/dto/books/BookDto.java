package ru.itis.karakurik.site.dto.books;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import ru.itis.karakurik.site.model.books.Book;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class BookDto {
    private Long id;
    private String name;
    private String contentFileName;
    private int pageCount;
    private String isbn;
    private String genre;
    private String author;
    private int publishDate;
    private String publisher;
    private byte[] image;

    public static BookDto from(Book book) {
        return BookDto.builder()
                .id(book.getId())
                .name(book.getName())
                .contentFileName(book.getContentFileName())
                .pageCount(book.getPageCount())
                .isbn(book.getIsbn())
                .genre(book.getGenre().getName())
                .author(book.getAuthors().stream().findFirst().get().getName())
                .publishDate(book.getPublishDate())
                .publisher(book.getPublisher().getName())
                .image(book.getImage())
                .build();
    }
}
