package com.learning.Student_Management_System.exception;

public class StudentNotInGroup extends RuntimeException {
    public StudentNotInGroup(String message) {
        super(message);
    }
}
