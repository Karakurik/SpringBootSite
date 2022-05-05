package ru.itis.karakurik.site.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.karakurik.site.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByEmail(String email);

    boolean existsUserByEmail(String email);
}
