package ru.itis.karakurik.site.service.books.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.karakurik.site.dto.books.AuthorDto;
import ru.itis.karakurik.site.exception.books.AuthorNotFoundException;
import ru.itis.karakurik.site.repository.AuthorRepository;
import ru.itis.karakurik.site.service.books.interfaces.AuthorService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    @Override
    public List<AuthorDto> getAuthorList() {
        return authorRepository.findAll().stream()
                .map(AuthorDto::from)
                .collect(Collectors.toList());
    }

    @Override
    public AuthorDto find(String name) {
        return AuthorDto.from(authorRepository.findAuthorByName(name).orElseThrow(AuthorNotFoundException::new));
    }
}
