package com.learning.Student_Management_System.service;

import com.learning.Student_Management_System.dto.teacher.TeacherRequestDTO;
import com.learning.Student_Management_System.dto.teacher.TeacherResponseDTO;

import java.util.List;

public interface TeacherService {
    TeacherResponseDTO addTeacher(TeacherRequestDTO teacherRequestDTO);
    List<TeacherResponseDTO> getAllTeachers();
}
