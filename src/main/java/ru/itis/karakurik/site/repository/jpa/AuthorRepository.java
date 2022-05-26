package ru.itis.karakurik.site.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.karakurik.site.model.books.Author;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    Optional<Author> findAuthorByName(String name);
}
