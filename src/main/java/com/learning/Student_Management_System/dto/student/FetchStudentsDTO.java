package com.learning.Student_Management_System.dto.student;

import jakarta.validation.constraints.NotNull;

import java.time.YearMonth;

public record FetchStudentsDTO(
        @NotNull
        YearMonth monthDate
) {}