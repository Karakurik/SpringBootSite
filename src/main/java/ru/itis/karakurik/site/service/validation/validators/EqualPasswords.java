package ru.itis.karakurik.site.service.validation.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = EqualPasswordsValidator.class)
@Target( {ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface EqualPasswords {
    String message() default "Пароли должны совпадать";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    String password();

    String passwordRepeat();

    @Target({ ElementType.TYPE })
    @Retention(RetentionPolicy.RUNTIME)
    @interface List {
        EqualPasswords[] value();
    }
}
