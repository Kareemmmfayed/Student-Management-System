package com.learning.Student_Management_System.dto.student;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record AttendanceRequestDTO(
        @NotNull
        LocalDate date
) {}