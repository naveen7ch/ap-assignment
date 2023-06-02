package com.example.ap.error;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler({ NoSuchElementException.class })
    public ResponseEntity<Object> handleAccessDeniedException(
            NoSuchElementException ex, WebRequest request) {
        return new ResponseEntity<Object>(
                "Unable to find entities relating to your query", new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
}
