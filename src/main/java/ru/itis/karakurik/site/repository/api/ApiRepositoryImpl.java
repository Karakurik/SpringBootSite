package ru.itis.karakurik.site.repository.api;

import okhttp3.*;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.itis.karakurik.site.exception.api.ApiException;

import java.io.IOException;

@Repository
public class ApiRepositoryImpl implements ApiRepository {
    private static final String BASE_URL = "https://pwv2r8.api.infobip.com";
    private static final String REDIRECT_URL = "http://localhost/changePassword";
    private static final String API_KEY = "App 0b5a60c6564eab0c64ffb29defc7e8f3-917124f8-b15b-409a-8255-e02055bcd844";

    private static final String SENDER_EMAIL_ADDRESS = "karakurik@selfserviceib.com";
    private static final String RECIPIENT_EMAIL_ADDRESS = "bycfasdf@gmail.com";

    private static final String EMAIL_SUBJECT = "Восcтановление пароля";
    private static final String EMAIL_TEXT = "Для восстановления паролся перейдите по ссылке:\n";
    @Autowired
    OkHttpClient okHttpClient;

    @Autowired
    Logger logger;


    @Override
    public void sendSms(String to, String message) {
        message = EMAIL_TEXT + REDIRECT_URL + "?token=" + message;
        RequestBody body = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("from", SENDER_EMAIL_ADDRESS)
                .addFormDataPart("to", to)
                .addFormDataPart("subject", "Восстановление пароля")
                .addFormDataPart("text", message).build();

        Request request = prepareHttpRequest(body);
        try {
            Response okHttpResponse = okHttpClient.newCall(request).execute();
            // TODO: 25.05.2022 тут бы спарсить в дата класс 
//            ru.itis.karakurik.site.dto.api.Response response
//                    = new Gson().fromJson(okHttpResponse.body().toString(), ru.itis.karakurik.site.dto.api.Response.class);
//            if (response.getMessages().get(0).getStatuses().get(0).getGroupName().equals("PENDING")) {
//                logger.error("Не удалось отправить сообщение");
//                throw new ApiException("Не удалось отправить сообщение");
//            }
            if (okHttpResponse.code() != 200) {
                throw new ApiException(String.valueOf(okHttpResponse.code()));
            }
            logger.info("HTTP status code: " + okHttpResponse.code());
            logger.info("Response body: " + okHttpResponse.body().string());
        } catch (IOException e) {
            throw new ApiException(e);
        }

    }

    private static Request prepareHttpRequest(RequestBody body) {
        return new Request.Builder()
                .url(String.format("%s/email/2/send", BASE_URL))
                .method("POST", body)
                .addHeader("Authorization", API_KEY)
                .addHeader("Content-Type", "text/plain")
                .addHeader("Accept", "application/json")
                .build();
    }
}
