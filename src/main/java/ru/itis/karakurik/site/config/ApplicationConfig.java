package ru.itis.karakurik.site.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.format.FormatterRegistry;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.itis.karakurik.site.converters.DateConverter;

@Configuration
@ComponentScan(basePackages = {
        "ru.itis.karakurik.site.service",
        "ru.itis.karakurik.site.controller",
        "ru.itis.karakurik.site.security",
        "ru.itis.karakurik.site.aspects.logging",
        "ru.itis.karakurik.site.repository"
})
@EntityScan(basePackages = "ru.itis.karakurik.site.model")
@EnableJpaRepositories(basePackages = "ru.itis.karakurik.site.repository")
@EnableAspectJAutoProxy
@Import(NetworkConfig.class)
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

    @Bean
    public Logger logger() {
        return LoggerFactory.getLogger("application");
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:static/");
    }

    @Bean
    public DateConverter dateConverter() {
        return new DateConverter();
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(dateConverter());
    }

//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory(JpaVendorAdapter adapter,
//                                                                       DataSource dataSource) {
//        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
//        entityManagerFactory.setJpaVendorAdapter(adapter);
//        entityManagerFactory.setDataSource(dataSource);
//        entityManagerFactory.setPackagesToScan("ru.itis.karakurik.site.model");
//
//        return entityManagerFactory;
//    }
//
//    @Bean
//    public TransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
//        JpaTransactionManager manager = new JpaTransactionManager();
//        manager.setEntityManagerFactory(entityManagerFactory);
//        return manager;
//    }
}
