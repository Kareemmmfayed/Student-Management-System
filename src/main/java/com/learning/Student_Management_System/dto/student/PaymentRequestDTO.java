package com.learning.Student_Management_System.dto.student;

import com.learning.Student_Management_System.entity.Payment;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.time.YearMonth;

@Builder
public record PaymentRequestDTO(
        @NotNull
        YearMonth paidAt
) {}