package com.learning.Student_Management_System.service;

import com.learning.Student_Management_System.dto.teacher.TeacherRequestDTO;
import com.learning.Student_Management_System.entity.Teacher;

public interface TeacherService {
    Teacher addTeacher(TeacherRequestDTO teacherRequestDTO);
}
