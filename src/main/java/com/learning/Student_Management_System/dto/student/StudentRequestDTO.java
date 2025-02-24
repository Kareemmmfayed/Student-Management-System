package com.learning.Student_Management_System.dto.student;

import jakarta.validation.constraints.NotNull;

public record StudentRequestDTO(
        @NotNull(message = "You must provide a first name.")
        String firstName,

        @NotNull(message = "You must provide a last name.")
        String lastName,

        @NotNull(message = "You must provide a phone number.")
        String phoneNumber,

        @NotNull(message = "You must provide a group.")
        Long groupId,

        @NotNull(message = "You must provide a address.")
        String address
) {}