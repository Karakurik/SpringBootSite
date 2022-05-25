package ru.itis.karakurik.site.exception.books;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.itis.karakurik.site.exception.NotFoundException;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BookNotFoundException extends NotFoundException {
    private final String className = "Book";
}
