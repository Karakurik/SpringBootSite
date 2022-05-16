package ru.itis.karakurik.site.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.karakurik.site.model.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {

}
