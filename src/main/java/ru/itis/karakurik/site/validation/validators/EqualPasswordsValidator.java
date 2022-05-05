package ru.itis.karakurik.site.validation.validators;

import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EqualPasswordsValidator implements ConstraintValidator<EqualPasswords, Object> {

    private String password;
    private String passwordRepeat;

    @Override
    public void initialize(EqualPasswords constraintAnnotation) {
        password = constraintAnnotation.password();
        passwordRepeat = constraintAnnotation.passwordRepeat();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        final BeanWrapperImpl bean = new BeanWrapperImpl(value);

        String p = (String) bean.getPropertyValue(this.password);
        String pR = (String) bean.getPropertyValue(this.passwordRepeat);

        return p != null && p.equals(pR);
    }
}
