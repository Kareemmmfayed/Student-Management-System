package com.learning.Student_Management_System.dto.student;

import com.learning.Student_Management_System.enums.Grade;
import jakarta.validation.constraints.NotNull;

public record StudentRequestDTO(
        @NotNull(message = "You must provide The Student's first name.")
        String firstName,

        @NotNull(message = "You must provide The Student's last name.")
        String lastName,

        @NotNull(message = "You must provide The Student's phone number.")
        String phoneNumber,

        @NotNull(message = "You must provide The Student's address.")
        String address,

        @NotNull(message = "You must provide The Student's grade.")
        Grade grade,

        @NotNull(message = "You must provide The Student's group.")
        Long groupId
) {}