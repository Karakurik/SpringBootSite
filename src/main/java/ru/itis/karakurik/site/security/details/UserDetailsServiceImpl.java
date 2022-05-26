package ru.itis.karakurik.site.security.details;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.itis.karakurik.site.exception.user.UserNotFoundException;
import ru.itis.karakurik.site.repository.jpa.UserRepository;

@Component
@RequiredArgsConstructor
@CustomUserDetailsService
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return new UserDetailsImpl(
                userRepository.findUserByEmail(email)
                        .orElseThrow(UserNotFoundException::new)
        );
    }
}
