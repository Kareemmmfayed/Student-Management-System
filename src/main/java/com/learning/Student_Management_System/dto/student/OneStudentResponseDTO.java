package com.learning.Student_Management_System.dto.student;

import com.learning.Student_Management_System.enums.Grade;
import com.learning.Student_Management_System.entity.Payment;
import com.learning.Student_Management_System.entity.Student;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

@Builder
public record OneStudentResponseDTO(
        Long id,
        String firstName,
        String lastName,
        String phoneNumber,
        String address,
        Grade grade
) {
    public static OneStudentResponseDTO makeStudentResponseDTOFromStudent(Student student) {

        return OneStudentResponseDTO.builder()
                .id(student.getId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .phoneNumber(student.getPhoneNumber())
                .address(student.getAddress())
                .grade(student.getGrade())
                .build();
    }
}