package ru.itis.karakurik.site.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.karakurik.site.model.books.Genre;

import java.util.Optional;

public interface GenreRepository extends JpaRepository<Genre, Long> {
    Optional<Genre> findGenreByName(String name);
}
