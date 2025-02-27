package com.learning.Student_Management_System.controller;

import com.learning.Student_Management_System.dto.student.*;
import com.learning.Student_Management_System.enums.Grade;
import com.learning.Student_Management_System.service.PaymentService;
import com.learning.Student_Management_System.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.YearMonth;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;
    private final PaymentService paymentService;

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

    @PostMapping("/payments/{studentId}")
    public ResponseEntity<String> addPayment(@PathVariable Long studentId, @RequestBody PaymentRequestDTO paymentDTO) {
        return ResponseEntity.ok(paymentService.addPayment(studentId, paymentDTO));
    }
}
