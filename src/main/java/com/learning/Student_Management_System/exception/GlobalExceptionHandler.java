package com.learning.Student_Management_System.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.rmi.StubNotFoundException;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TeacherNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleTeacherNotFoundException(Exception e) {
        Map<String, String> errors = new HashMap<>();
        errors.put("error", e.getMessage());
        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TeacherNotSuitableException.class)
    public ResponseEntity<Map<String, String>> handleTeacherNotSuitableException(Exception e) {
        Map<String, String> errors = new HashMap<>();
        errors.put("error", e.getMessage());
        return new ResponseEntity<>(errors, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(StubNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleStudentNotFoundException(Exception e) {
        Map<String, String> errors = new HashMap<>();
        errors.put("error", e.getMessage());
        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(StudentNotSuitableForGroupException.class)
    public ResponseEntity<Map<String, String>> handleStudentNotSuitableException(Exception e) {
        Map<String, String> errors = new HashMap<>();
        errors.put("error", e.getMessage());
        return new ResponseEntity<>(errors, HttpStatus.CONFLICT);
    }
}