package com.felipeapn.auction.exception.handler;

import com.felipeapn.auction.exception.DataIntegrityViolationException;
import com.felipeapn.auction.exception.ObjectNotFoundException;
import com.felipeapn.auction.services.ValidationError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFoundException(
            ObjectNotFoundException ex, HttpServletRequest request) {

        StandardError standardError = StandardError.builder()
                .timestamp(System.currentTimeMillis())
                .error("Object not found")
                .message(ex.getMessage())
                .path(request.getRequestURI())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standardError);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<StandardError> dataIntegrityViolationException(
            DataIntegrityViolationException ex, HttpServletRequest request) {

        StandardError standardError = StandardError.builder()
                .timestamp(System.currentTimeMillis())
                .error("Object not found")
                .message(ex.getMessage())
                .path(request.getRequestURI())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standardError);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> validationErrors(
            MethodArgumentNotValidException ex, HttpServletRequest request) {

        ValidationError errors = new ValidationError(System.currentTimeMillis(),"Validation Error",
                "Field validation error", request.getRequestURI());

        ex.getBindingResult().getFieldErrors().stream()
                .forEach(x -> errors.addErrors(x.getField(), x.getDefaultMessage()));

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errors);
    }
}
