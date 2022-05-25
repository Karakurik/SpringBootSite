package ru.itis.karakurik.site.service.api;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.karakurik.site.model.api.UserChangePasswordToken;
import ru.itis.karakurik.site.repository.api.ApiRepository;
import ru.itis.karakurik.site.repository.api.UserChangePasswordTokenRepository;

@Service
@RequiredArgsConstructor
public class ApiServiceImpl implements ApiService {

    @Autowired
    private ApiRepository apiRepository;
    private final UserChangePasswordTokenRepository userChangePasswordTokenRepository;

    @Override
    public void sendSms(String to, String message) {
        apiRepository.sendSms(to, message);
    }

    @Override
    public String getEmailByToken(String token) {
        return userChangePasswordTokenRepository.getByToken(token).orElse(new UserChangePasswordToken()).getEmail();
    }

    @Override
    public void saveToken(String email, String token) {
        userChangePasswordTokenRepository.save(
                UserChangePasswordToken.builder()
                        .email(email)
                        .token(token)
                        .build()
        );
    }
}
