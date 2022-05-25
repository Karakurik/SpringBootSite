package ru.itis.karakurik.site.controller.exceptionHandler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;
import ru.itis.karakurik.site.exception.NotFoundException;

@Slf4j
@ControllerAdvice
public class ExceptionHandlerResponse {

//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ValidationExceptionResponse handleException(MethodArgumentNotValidException exception) {
//        List<ValidationErrorDto> errors = new ArrayList<>();
//        exception.getBindingResult().getAllErrors().forEach((error) -> {
//
//            String errorMessage = error.getDefaultMessage();
//            ValidationErrorDto errorDto = ValidationErrorDto.builder()
//                    .message(errorMessage)
//                    .build();
//
//            if (error instanceof FieldError) {
//                String fieldName = ((FieldError) error).getField();
//                errorDto.setField(fieldName);
//            } else if (error instanceof ObjectError) {
//                String objectName = error.getObjectName();
//                errorDto.setObject(objectName);
//            }
//            errors.add(errorDto);
//        });
//
//        return ValidationExceptionResponse.builder()
//                .errors(errors)
//                .build();
//    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String serverException() {
        log.error("Server error");
        return "exception/exception_page";
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(HttpClientErrorException.Forbidden.class)
    public String forbidden(ModelMap map, HttpClientErrorException.Forbidden exception) {
        log.error("forbidden");
        map.put("exception", exception);
        return "exception/exception";
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public String notFoundException(ModelMap map, NotFoundException exception) {
        log.error(exception.getClassName() + " not found");
        map.put("exception", exception);
        return "exception/exception";
    }

//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    @ExceptionHandler()
//    public ModelAndView notFoundException(Exception exception) {
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("exception", exception);
//        mav.setViewName("exception/exception_not_found");
//        return mav;
//    }

    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public String handleError(Throwable throwable) {
        log.error(throwable.toString());
        log.error(throwable.getMessage());
        return "Неизвестная ошибка";
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String handleError(Exception ex) {
        log.error(ex.toString());
        log.error(ex.getMessage());
        return "Неизвестная ошибка";
    }
}
