package com.learning.Student_Management_System.controller;

import com.learning.Student_Management_System.dto.student.PaymentRequestDTO;
import com.learning.Student_Management_System.dto.student.StudentRequestDTO;
import com.learning.Student_Management_System.dto.student.StudentResponseDTO;
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

    @PostMapping
    public ResponseEntity<StudentResponseDTO> addStudent(@RequestBody StudentRequestDTO studentRequestDTO) {
        return ResponseEntity.ok(studentService.addStudent(studentRequestDTO));
    }

    @GetMapping
    public ResponseEntity<List<StudentResponseDTO>> getStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @PostMapping("/payments/${studentId}")
    public ResponseEntity<String> addPayment(@PathVariable Long studentId, @RequestBody PaymentRequestDTO paymentDTO) {
        return ResponseEntity.ok("Payment was added successfully!");
    }
}
