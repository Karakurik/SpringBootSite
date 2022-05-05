package ru.itis.karakurik.site.service;

import ru.itis.karakurik.site.dto.LoginForm;
import ru.itis.karakurik.site.dto.SignUpForm;
import ru.itis.karakurik.site.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User signUp(SignUpForm form);
    User login(LoginForm form);
}
