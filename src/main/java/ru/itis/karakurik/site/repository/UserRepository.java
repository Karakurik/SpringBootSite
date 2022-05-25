package ru.itis.karakurik.site.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.itis.karakurik.site.model.user.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByEmail(String email);

    boolean existsUserByEmail(String email);

    @Query(
            nativeQuery = true,
            value = "UPDATE library_user " +
                    "SET hash_password = :hash_password " +
                    "WHERE email =:email"
    )
    User changePassword(
            @Param("email") String email,
            @Param("hash_password") String newHashPassword
    );
}
