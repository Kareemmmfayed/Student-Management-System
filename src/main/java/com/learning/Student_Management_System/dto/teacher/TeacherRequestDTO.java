package com.learning.Student_Management_System.dto.teacher;

import com.learning.Student_Management_System.enums.Subject;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record TeacherRequestDTO(

        @NotNull(message = "You must provide the teacher's first name!")
        @Size(min=2, max=30, message = "The first name must be between 2 and 30 characters!")
        String firstName,

        @NotNull(message = "You must provide the teacher's last name!")
        @Size(min=2, max=30, message = "The last name must be between 2 and 30 characters!")
        String lastName,

        @NotNull(message = "You must provide the teacher's phone number!")
        @Size(min = 11, max = 11, message = "The phone number must be 11 characters!")
        String phoneNumber,

        @NotNull(message = "You must provide the teacher's email!")
        @Email
        String email,

        @NotNull(message = "You must provide the teacher's address!")
        String address,

        @NotNull(message = "You must provide the teacher's subject!")
        Subject subject
) {}