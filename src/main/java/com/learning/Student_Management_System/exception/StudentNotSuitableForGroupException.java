package com.learning.Student_Management_System.exception;

public class StudentNotSuitableForGroupException extends RuntimeException {
    public StudentNotSuitableForGroupException(String message) {
        super(message);
    }
}
