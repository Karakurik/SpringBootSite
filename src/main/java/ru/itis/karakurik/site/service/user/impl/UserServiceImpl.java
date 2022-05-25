package ru.itis.karakurik.site.service.user.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.karakurik.site.dto.auth.LoginForm;
import ru.itis.karakurik.site.dto.auth.SignUpForm;
import ru.itis.karakurik.site.exception.auth.OccupiedEmailException;
import ru.itis.karakurik.site.exception.auth.WrongPasswordException;
import ru.itis.karakurik.site.exception.user.UserNotFoundException;
import ru.itis.karakurik.site.model.user.Role;
import ru.itis.karakurik.site.model.user.State;
import ru.itis.karakurik.site.model.user.User;
import ru.itis.karakurik.site.repository.UserRepository;
import ru.itis.karakurik.site.service.user.interfaces.UserService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @PersistenceContext
    private final EntityManager em;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User signUp(SignUpForm form) {
        if (userRepository.existsUserByEmail(form.getEmail())) {
            throw new OccupiedEmailException("Email " + form.getEmail() + " is occupied");
        }

        User user = User.builder()
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
        User user = userRepository.findUserByEmail(form.getEmail()).orElseThrow(UserNotFoundException::new);

        if (!passwordEncoder.matches(form.getPassword(), user.getHashPassword())) {
            throw new WrongPasswordException();
        }

        return user;
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findUserByEmail(email).orElse(null);
    }

    @Override
//    @Transactional
    public void changePassword(String email, String newPassword) {
        String hashPassword = passwordEncoder.encode(newPassword);
//        Query query = em.createQuery(
//                "UPDATE User SET hashPassword = :hashPassword WHERE email = :email");
//        query.setParameter("hashPassword", hashPassword);
//        query.setParameter("email", email);
//        int updateCount = query.executeUpdate();
        userRepository.changePassword(email, hashPassword);
    }
}
