package com.alamgir.payment_service.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class GlobalException {

    // Method for : MethodArgumentNotValidException
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException ex,
            HttpServletRequest request) {

        List<FieldError> errors = ex.getFieldErrors();
        List<String> response = errors.stream().map(e -> e.getField() + ":::::" + e.getDefaultMessage()).toList();
        return ResponseEntity.badRequest().body(response);
    }

    // // Method for : ConstraintViolationException
    // @ExceptionHandler(ConstraintViolationException.class)
    // public ResponseEntity<?>
    // handleConstraintViolationException(ConstraintViolationException ex) {
    // return ResponseEntity.internalServerError().body("Try again later");
    // }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> handleConstraintViolationException(ConstraintViolationException ex) {
        // Collect all violation messages into a list or single string
        var messages = ex.getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toList());

        return ResponseEntity.badRequest().body(messages);
    }

}
