package ru.itis.karakurik.site.config;

import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NetworkConfig {

    @Bean
    public OkHttpClient okHttpClient() {
        return new OkHttpClient().newBuilder().build();
    }

//    @Bean
//    public Api api() {
//        return new Retrofit.Builder()
//                .baseUrl("https://www.googleapis.com/")
//                .client(okHttpClient())
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//                .create(Api.class);
//    }
}
