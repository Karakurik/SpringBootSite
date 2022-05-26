package ru.itis.karakurik.site.service.books.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.karakurik.site.dto.books.GenreDto;
import ru.itis.karakurik.site.exception.books.GenreNotFoundException;
import ru.itis.karakurik.site.repository.jpa.GenreRepository;
import ru.itis.karakurik.site.service.books.interfaces.GenreService;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class GenreServiceImpl implements GenreService {
    private final GenreRepository genreRepository;

    @Override
    public List<GenreDto> getGenreList() {
        return genreRepository.findAll().stream().map(GenreDto::from).collect(Collectors.toList());
    }

    @Override
    public GenreDto find(String name) {
        return GenreDto.from(genreRepository.findGenreByName(name).orElseThrow(GenreNotFoundException::new));
    }
}
