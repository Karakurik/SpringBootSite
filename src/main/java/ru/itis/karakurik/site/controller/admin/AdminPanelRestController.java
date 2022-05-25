package ru.itis.karakurik.site.controller.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import ru.itis.karakurik.site.dto.books.BookDto;
import ru.itis.karakurik.site.dto.validation.ValidationErrorDto;
import ru.itis.karakurik.site.dto.validation.ValidationExceptionResponse;
import ru.itis.karakurik.site.service.books.interfaces.AuthorService;
import ru.itis.karakurik.site.service.books.interfaces.BookService;
import ru.itis.karakurik.site.service.books.interfaces.GenreService;
import ru.itis.karakurik.site.service.books.interfaces.PublisherService;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/rest")
public class AdminPanelRestController {

    private final BookService bookService;
    private final GenreService genreService;
    private final AuthorService authorService;
    private final PublisherService publisherService;

    @PatchMapping("/delete/{book-id}")
    public HttpStatus deleteBook(@PathVariable("book-id") Long id) {
        bookService.deleteBook(id);
        return HttpStatus.OK;
    }

    @PutMapping("/edit/{book-id}")
    public HttpStatus editBook(
            @PathVariable("book-id") Long id,
            @RequestBody BookDto bookDto
    ) {
        Long genreId = genreService.find(bookDto.getGenre()).getId();
        Long authorId = authorService.find(bookDto.getAuthor()).getId();
        Long publisherId = publisherService.find(bookDto.getPublisher()).getId();
        bookService.update(
                id,
                bookDto.getName(),
                bookDto.getPageCount(),
                bookDto.getIsbn(),
                genreId,
                authorId,
                bookDto.getPublishDate(),
                publisherId
        );
        return HttpStatus.OK;
    }

    @GetMapping("/")
    public ResponseEntity<List<BookDto>> getAllBooks() {
        List<BookDto> books = bookService.getAllBooks();
        if (books != null) {
            return ResponseEntity.ok(books);
        } else if (books.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add")
    public HttpStatus addBook(@RequestBody BookDto bookDto) {
        bookService.save(bookDto);
        return HttpStatus.OK;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ValidationExceptionResponse handleException(MethodArgumentNotValidException exception) {
        List<ValidationErrorDto> errors = new ArrayList<>();
        exception.getBindingResult().getAllErrors().forEach((error) -> {

            String errorMessage = error.getDefaultMessage();
            ValidationErrorDto errorDto = ValidationErrorDto.builder()
                    .message(errorMessage)
                    .build();

            if (error instanceof FieldError) {
                String fieldName = ((FieldError) error).getField();
                errorDto.setField(fieldName);
            } else if (error instanceof ObjectError) {
                String objectName = error.getObjectName();
                errorDto.setObject(objectName);
            }
            errors.add(errorDto);
        });

        return ValidationExceptionResponse.builder()
                .errors(errors)
                .build();
    }
}
