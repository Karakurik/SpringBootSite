package ru.itis.karakurik.site.service;

import ru.itis.karakurik.site.dto.GenreDto;

import java.util.List;

public interface GenreService {
    List<GenreDto> getAllGenres();
}
