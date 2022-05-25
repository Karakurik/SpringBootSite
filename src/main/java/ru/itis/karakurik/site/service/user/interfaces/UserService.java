package ru.itis.karakurik.site.service.user.interfaces;

import ru.itis.karakurik.site.dto.auth.LoginForm;
import ru.itis.karakurik.site.dto.auth.SignUpForm;
import ru.itis.karakurik.site.model.user.User;

public interface UserService {
    User signUp(SignUpForm form);

    User login(LoginForm form);

    User getUserByEmail(String email);

    void changePassword(String email, String newPassword);
}
