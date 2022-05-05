package ru.itis.karakurik.site.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.itis.karakurik.site.dto.LoginForm;
import ru.itis.karakurik.site.dto.SignUpForm;
import ru.itis.karakurik.site.exception.OccupiedEmailException;
import ru.itis.karakurik.site.exception.OccupiedUsernameException;
import ru.itis.karakurik.site.exception.UserNotFoundException;
import ru.itis.karakurik.site.exception.WrongPasswordException;
import ru.itis.karakurik.site.model.Role;
import ru.itis.karakurik.site.model.State;
import ru.itis.karakurik.site.model.User;
import ru.itis.karakurik.site.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Component
public class UserServiceJpaImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User signUp(SignUpForm form) {
        if (userRepository.existsUserByUsername(form.getUsername())) {
            throw new OccupiedUsernameException("Username " + form.getUsername() + " is occupied");
        } else if (userRepository.existsUserByEmail(form.getEmail())) {
            throw new OccupiedEmailException("Email " + form.getEmail() + " is occupied");
        }

        User user = User.builder()
                .username(form.getUsername())
                .email(form.getEmail())
                .firstName(form.getFirstName())
                .lastName(form.getLastName())
                .hashPassword(passwordEncoder.encode(form.getPassword()))
                .role(Role.ROLE_USER)
                .state(State.STATE_ACTIVE)
                .build();

        userRepository.save(user);

        return user;
    }

    @Override
    public User login(LoginForm form) {
        Optional<User> userCandidate = userRepository.findUserByUsernameOrEmail(form.getUsernameOrEmail(), form.getUsernameOrEmail());
        User user = userCandidate.orElseThrow(UserNotFoundException::new);

        if (!passwordEncoder.matches(form.getPassword(), user.getHashPassword())) {
            throw new WrongPasswordException();
        }

        return user;
    }
}
