package ru.itis.karakurik.site.controller.exceptionHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice
public class ExceptionHandlerResponseRest extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response> handleException(Exception e) {
        Response response = new Response(e.getMessage());
        log.error(e.toString());
        log.error(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException e, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Response response = new Response("Неправильный JSON", e.getMessage());
        log.error(e.toString());
        log.error(e.getMessage());
        return new ResponseEntity<>(response, status);
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public class Response {
        private String message;
        private String debugMessage;

        public Response(String debugMessage) {
            this.debugMessage = debugMessage;
        }
    }
}

