package com.learning.Student_Management_System.service;

import com.learning.Student_Management_System.dto.student.StudentRequestDTO;
import com.learning.Student_Management_System.dto.student.StudentResponseDTO;

import java.util.List;

public interface StudentService {
    StudentResponseDTO addStudent(StudentRequestDTO studentRequestDTO);
    List<StudentResponseDTO> getAllStudents();
}