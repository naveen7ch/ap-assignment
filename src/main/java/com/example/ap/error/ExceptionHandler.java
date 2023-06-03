package com.example.ap.error;

import org.springframework.dao.ConcurrencyFailureException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler({ NoSuchElementException.class })
    public ResponseEntity<ErrorResponse> noSuchElementException(
            NoSuchElementException ex, WebRequest request) {
        return new ResponseEntity<ErrorResponse>(
                new ErrorResponse("notFound", "Unable to find entities relating to your query"), HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<ErrorResponse> handleConcurrencyFailure(ConcurrencyFailureException ex, NativeWebRequest request) {
        return new ResponseEntity<ErrorResponse>(
                new ErrorResponse("concurrencyFailure", "Concurrency failure"), HttpStatus.CONFLICT);

    }

    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<ErrorResponse> handleDataIntegrityViolationException(DataIntegrityViolationException ex, NativeWebRequest request) {
        return new ResponseEntity<ErrorResponse>(
                new ErrorResponse("dataIntegrity", "Data Integrity failure", ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

        @org.springframework.web.bind.annotation.ExceptionHandler({ Exception.class })
    public ResponseEntity<ErrorResponse> exception(
            Exception ex, WebRequest request) {
        return new ResponseEntity<ErrorResponse>(
                new ErrorResponse("unknown", ex.getMessage(), ex.getCause().getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
