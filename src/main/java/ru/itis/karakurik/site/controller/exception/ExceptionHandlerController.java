package ru.itis.karakurik.site.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.NoHandlerFoundException;
import ru.itis.karakurik.site.exception.NotFoundException;

@ControllerAdvice
public class ExceptionHandlerController {

    @ResponseStatus(HttpStatus.FORBIDDEN)
    public String forbidden() {
        return "error/forbidden";
    }


    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String serverException() {
        return "exception/server";
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(HttpClientErrorException.Forbidden.class)
    public String forbidden(ModelMap map, HttpClientErrorException.Forbidden exception) {
        map.put("exception", exception);
        return "exception/exception";
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public String notFoundException(ModelMap map, NotFoundException exception) {
        map.put("exception", exception);
        return "exception/exception";
    }

    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public String handleError(Throwable throwable) {
        return "error/unknown";
    }

    @ExceptionHandler(Exception.class)
    public String handleError(Exception e) {
        return "error/unknown";
    }

    @ExceptionHandler(RuntimeException.class)
    public String handleError(RuntimeException e) {
        return "error/unknown";
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoHandlerFoundException.class)
    public String _404Exception(NoHandlerFoundException e) {
        return "exception/not_found";
    }
}
