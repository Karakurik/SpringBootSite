package ru.itis.karakurik.site.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.karakurik.site.dto.GenreDto;
import ru.itis.karakurik.site.repository.GenreRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    @Override
    public List<GenreDto> getAllGenres() {
        return genreRepository.findAll().stream()
                .map(GenreDto::from).collect(Collectors.toList());
    }
}
