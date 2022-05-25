package ru.itis.karakurik.site.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.karakurik.site.model.books.Publisher;

import java.util.Optional;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
    Optional<Publisher> findPublisherByName(String name);
}
