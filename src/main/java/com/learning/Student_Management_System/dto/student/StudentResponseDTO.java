package com.learning.Student_Management_System.dto.student;

import com.learning.Student_Management_System.enums.Grade;
import com.learning.Student_Management_System.entity.Payment;
import com.learning.Student_Management_System.entity.Student;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

@Builder
public record StudentResponseDTO(
        Long id,
        String firstName,
        String lastName,
        String phoneNumber,
        Grade grade,
        List<Payment> payments
) {
    public static StudentResponseDTO makeStudentResponseDTOFromStudent(Student student) {
        return StudentResponseDTO.builder()
                .id(student.getId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .phoneNumber(student.getPhoneNumber())
                .grade(student.getGrade())
                .payments(student.getPayments())
                .build();
    }
}