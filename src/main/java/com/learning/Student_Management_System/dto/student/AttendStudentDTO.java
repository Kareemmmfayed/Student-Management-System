package com.learning.Student_Management_System.dto.student;

import java.time.LocalDate;

public record AttendStudentDTO(
        LocalDate attendedAt
) {}