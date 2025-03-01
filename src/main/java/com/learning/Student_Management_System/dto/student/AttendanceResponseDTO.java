package com.learning.Student_Management_System.dto.student;

import com.learning.Student_Management_System.entity.Attendance;
import lombok.Builder;

@Builder
public record AttendanceResponseDTO(
        Long id,
        String firstName,
        String lastName,
        String phoneNumber,
        boolean attended
) {}