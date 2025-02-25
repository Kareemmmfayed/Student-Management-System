package com.learning.Student_Management_System.dto.teacher;

import com.learning.Student_Management_System.enums.Subject;
import com.learning.Student_Management_System.entity.Teacher;
import lombok.Builder;

@Builder
public record TeacherResponseDTO(
        Long id,
        String firstName,
        String lastName,
        String email,
        String phoneNumber,
        String address,
        Subject subject
) {
    public static TeacherResponseDTO makeTeacherResponseDTOFromTeacher(Teacher teacher) {
        return TeacherResponseDTO.builder()
                .id(teacher.getId())
                .firstName(teacher.getFirstName())
                .lastName(teacher.getLastName())
                .email(teacher.getEmail())
                .phoneNumber(teacher.getPhoneNumber())
                .address(teacher.getAddress())
                .subject(teacher.getSubject())
                .build();
    }
}