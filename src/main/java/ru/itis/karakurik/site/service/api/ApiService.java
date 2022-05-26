package ru.itis.karakurik.site.service.api;

public interface ApiService {

    void sendSms(String to, String message);

    String getEmailByToken(String token);

    void saveToken(String email, String token);
}
