package com.learning.Student_Management_System.service;

import com.learning.Student_Management_System.dto.student.AttendStudentDTO;
import com.learning.Student_Management_System.dto.student.AttendanceRequestDTO;
import com.learning.Student_Management_System.dto.student.AttendanceResponseDTO;

import java.time.LocalDate;
import java.util.List;

public interface AttendanceService {
    List<AttendanceResponseDTO> getAttendance(AttendanceRequestDTO attendanceRequestDTO, Long groupId);
    String attendStudent(Long studentId, Long groupId, AttendStudentDTO attendStudentDTO);
    String deleteAttendance(Long attendanceId);
}
