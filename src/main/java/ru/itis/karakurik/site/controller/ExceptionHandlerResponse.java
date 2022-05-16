package ru.itis.karakurik.site.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.itis.karakurik.site.validation.http.ValidationErrorDto;
import ru.itis.karakurik.site.validation.http.ValidationExceptionResponse;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@ControllerAdvice
public class ExceptionHandlerResponse {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ValidationExceptionResponse handleException(MethodArgumentNotValidException exception) {
        List<ValidationErrorDto> errors = new ArrayList<>();
        exception.getBindingResult().getAllErrors().forEach((error) -> {

            String errorMessage = error.getDefaultMessage();
            ValidationErrorDto errorDto = ValidationErrorDto.builder()
                    .message(errorMessage)
                    .build();

            if (error instanceof FieldError) {
                String fieldName = ((FieldError) error).getField();
                errorDto.setField(fieldName);
            } else if (error instanceof ObjectError) {
                String objectName = error.getObjectName();
                errorDto.setObject(objectName);
            }
            errors.add(errorDto);
        });

        return ValidationExceptionResponse.builder()
                .errors(errors)
                .build();
    }

//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    @ExceptionHandler(Exception.class)
//    public String serverException() {
//        return "exception/exception_page";
//    }

//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    @ExceptionHandler(Exception.class)
//    public String notFoundException() {
//        return "exception/exception_page";
//    }

    @ExceptionHandler(RuntimeException.class)
    public void postRuntimeException(RuntimeException exception) {
        log.error(exception.toString());
        log.error(exception.getMessage());
    }
}
