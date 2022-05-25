package ru.itis.karakurik.site.repository.api;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.karakurik.site.model.api.UserChangePasswordToken;

import java.util.Optional;

public interface UserChangePasswordTokenRepository extends JpaRepository<UserChangePasswordToken, Long> {
    Optional<UserChangePasswordToken> getByToken(String token);
}
