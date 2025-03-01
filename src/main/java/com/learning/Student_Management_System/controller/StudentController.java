package com.learning.Student_Management_System.controller;

import com.learning.Student_Management_System.dto.student.*;
import com.learning.Student_Management_System.enums.Grade;
import com.learning.Student_Management_System.service.AttendanceService;
import com.learning.Student_Management_System.service.PaymentService;
import com.learning.Student_Management_System.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;
    private final PaymentService paymentService;
    private final AttendanceService attendanceService;

    @PostMapping
    public ResponseEntity<OneStudentResponseDTO> addStudent(@RequestBody StudentRequestDTO studentRequestDTO) {
        return ResponseEntity.ok(studentService.addStudent(studentRequestDTO));
    }

    @GetMapping
    public ResponseEntity<List<StudentResponseDTO>> getStudents(
            @RequestParam(name = "monthDate", required = true) YearMonth monthDate,
            @RequestParam(name = "grade", required = false) Grade studentGrade
            ) {
        return ResponseEntity.ok(studentService.getStudents(monthDate, studentGrade));
    }

    @PostMapping("/{studentId}/payments")
    public ResponseEntity<String> addPayment(
            @PathVariable Long studentId,
            @RequestBody PaymentRequestDTO paymentDTO
    ) {
        return ResponseEntity.ok(paymentService.addPayment(studentId, paymentDTO));
    }

    @DeleteMapping("/payments/{paymentId}")
    public ResponseEntity<String> deletePayment(@PathVariable Long paymentId) {
        return ResponseEntity.ok(paymentService.deletePayment(paymentId));
    }

    @PostMapping("/{studentId}/attend/{groupId}")
    public ResponseEntity<String> addAttendance(
            @PathVariable Long studentId,
            @PathVariable Long groupId,
            @RequestBody AttendStudentDTO attendStudentDTO
    ) {
        return ResponseEntity.ok(attendanceService.attendStudent(studentId, groupId, attendStudentDTO));
    }

    @DeleteMapping("/attend/{attendanceId}")
    public ResponseEntity<String> deleteAttendance(@PathVariable Long attendanceId) {
        return ResponseEntity.ok(attendanceService.deleteAttendance(attendanceId));
    }

    @GetMapping("/attendance/{groupId}")
    public ResponseEntity<List<AttendanceResponseDTO>> getAttendance(
            @PathVariable Long groupId,
            @RequestBody AttendanceRequestDTO attendanceRequestDTO
    ) {
        return ResponseEntity.ok(attendanceService.getAttendance(attendanceRequestDTO, groupId));
    }
}
