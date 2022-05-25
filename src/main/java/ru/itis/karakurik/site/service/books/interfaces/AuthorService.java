package ru.itis.karakurik.site.service.books.interfaces;

import ru.itis.karakurik.site.dto.books.AuthorDto;

import java.util.List;

public interface AuthorService {
    List<AuthorDto> getAuthorList();

    AuthorDto find(String name);
}
