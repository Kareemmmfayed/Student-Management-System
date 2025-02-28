package com.learning.Student_Management_System.dto.group;

import com.learning.Student_Management_System.enums.Day;

import java.time.LocalTime;

public record PeriodRequestDTO(
        Day day,
        LocalTime startDate
) {}