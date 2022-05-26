package ru.itis.karakurik.site.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.karakurik.site.model.user.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByEmail(String email);

    boolean existsUserByEmail(String email);

    @Transactional
    @Modifying
    @Query("UPDATE User " +
            "SET hashPassword = :hashPassword " +
            "WHERE email = :email"
    )
    void changePassword(
            @Param("email") String email,
            @Param("hashPassword") String hashPassword
    );
}
