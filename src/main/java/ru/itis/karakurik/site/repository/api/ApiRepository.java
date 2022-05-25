package ru.itis.karakurik.site.repository.api;

public interface ApiRepository {
    void sendSms(String to, String message);
}
