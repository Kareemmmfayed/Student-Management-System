package com.learning.Student_Management_System.service;

import com.learning.Student_Management_System.dto.student.StudentResponseDTO;
import com.learning.Student_Management_System.dto.student.StudentRequestDTO;
import com.learning.Student_Management_System.dto.student.OneStudentResponseDTO;
import com.learning.Student_Management_System.enums.Grade;

import java.time.YearMonth;
import java.util.List;

public interface StudentService {
    OneStudentResponseDTO addStudent(StudentRequestDTO studentRequestDTO);
    List<StudentResponseDTO> getStudents(YearMonth fetchStudentsDTO, Grade grade);
}