package ru.itis.karakurik.site.config;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.format.FormatterRegistry;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.itis.karakurik.site.aspects.logging.LoggerAspect;
import ru.itis.karakurik.site.converters.DateConverter;

@Configuration
@ComponentScan(basePackages = {
        "ru.itis.karakurik.site.service",
        "ru.itis.karakurik.site.controller",
        "ru.itis.karakurik.site.security",
        "ru.itis.karakurik.site.aspects.logging"
})
@EntityScan(basePackages = "ru.itis.karakurik.site.model")
@EnableJpaRepositories(basePackages = "ru.itis.karakurik.site.repository")
@EnableAspectJAutoProxy
public class ApplicationConfig implements WebMvcConfigurer {

    private final Environment environment;

    @Autowired
    public ApplicationConfig(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public Logger logger() {
//        return (Logger) LoggerFactory.getLogger(LoggerAspect.class);
//    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:static/");
    }

    @Bean
    DateConverter dateConverter() {
        return new DateConverter();
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(dateConverter());
    }
}
