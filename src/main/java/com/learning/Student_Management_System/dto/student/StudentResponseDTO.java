package com.learning.Student_Management_System.dto.student;

import com.learning.Student_Management_System.enums.Grade;
import lombok.Builder;

@Builder
public record StudentResponseDTO(
        Long id,
        String firstName,
        String lastName,
        String phoneNumber,
        Grade grade,
        Boolean paid
) {}