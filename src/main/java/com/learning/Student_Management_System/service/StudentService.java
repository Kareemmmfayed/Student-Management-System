package com.learning.Student_Management_System.service;

import com.learning.Student_Management_System.dto.student.FetchStudentsDTO;
import com.learning.Student_Management_System.dto.student.StudentAPIResponseDTO;
import com.learning.Student_Management_System.dto.student.StudentRequestDTO;
import com.learning.Student_Management_System.dto.student.OneStudentResponseDTO;

import java.util.List;

public interface StudentService {
    OneStudentResponseDTO addStudent(StudentRequestDTO studentRequestDTO);
    List<StudentAPIResponseDTO> getAllStudents(FetchStudentsDTO fetchStudentsDTO);
}