package ru.itis.karakurik.site.service.validation.interfaces;

import org.springframework.validation.BindingResult;

public interface ValidationService {
    String getErrors(BindingResult bindingResult);
}