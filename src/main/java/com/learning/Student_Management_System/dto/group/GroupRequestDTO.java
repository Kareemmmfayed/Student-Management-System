package com.learning.Student_Management_System.dto.group;

import com.learning.Student_Management_System.enums.Grade;
import com.learning.Student_Management_System.enums.Subject;
import jakarta.validation.constraints.NotNull;

public record GroupRequestDTO(

        @NotNull(message = "You must provide the Subject of the group!")
        Subject subject,

        @NotNull(message = "You must provide the grade of the students of the group!")
        Grade grade
) {}