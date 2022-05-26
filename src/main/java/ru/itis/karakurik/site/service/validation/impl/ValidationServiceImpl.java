package ru.itis.karakurik.site.service.validation.impl;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import ru.itis.karakurik.site.service.validation.interfaces.ValidationService;

@Service
public class ValidationServiceImpl implements ValidationService {
    @Override
    public String getErrors(BindingResult bindingResult) {
        StringBuilder sb = new StringBuilder();
        for (ObjectError error : bindingResult.getAllErrors()) {
            sb.append(error.getDefaultMessage() + "\n");
        }
        return sb.toString();
    }
}
