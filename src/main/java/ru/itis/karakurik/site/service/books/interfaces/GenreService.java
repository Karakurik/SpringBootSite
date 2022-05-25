package ru.itis.karakurik.site.service.books.interfaces;

import ru.itis.karakurik.site.dto.books.GenreDto;

import java.util.List;

public interface GenreService {
    List<GenreDto> getGenreList();

    GenreDto find(String name);
}
