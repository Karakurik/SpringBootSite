package ru.itis.karakurik.site.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import ru.itis.karakurik.site.config.ApplicationConfig;
import ru.itis.karakurik.site.security.config.SecurityConfig;

//@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@EnableAspectJAutoProxy
@Import({ApplicationConfig.class, SecurityConfig.class})
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.run(args);
    }
}
