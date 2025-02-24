package com.learning.Student_Management_System.dto.group;

import com.learning.Student_Management_System.entity.Grade;
import com.learning.Student_Management_System.entity.Subject;
import com.learning.Student_Management_System.entity.Teacher;

public record GroupRequestDTO(
        Subject subject,
        Teacher teacher,
        Grade grade
) {}