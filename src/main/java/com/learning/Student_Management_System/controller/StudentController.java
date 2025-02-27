package com.learning.Student_Management_System.controller;

import com.learning.Student_Management_System.dto.student.*;
import com.learning.Student_Management_System.service.PaymentService;
import com.learning.Student_Management_System.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<List<StudentAPIResponseDTO>> getStudents(@RequestBody FetchStudentsDTO fetchStudentsDTO) {
        return ResponseEntity.ok(studentService.getAllStudents(fetchStudentsDTO));
    }

    @PostMapping("/payments/{studentId}")
    public ResponseEntity<String> addPayment(@PathVariable Long studentId, @RequestBody PaymentRequestDTO paymentDTO) {
        return ResponseEntity.ok(paymentService.addPayment(studentId, paymentDTO));
    }
}
