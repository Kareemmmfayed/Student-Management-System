package com.learning.Student_Management_System.controller;

import com.learning.Student_Management_System.dto.teacher.TeacherRequestDTO;
import com.learning.Student_Management_System.dto.teacher.TeacherResponseDTO;
import com.learning.Student_Management_System.entity.Teacher;
import com.learning.Student_Management_System.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @PostMapping
    public ResponseEntity<TeacherResponseDTO> addTeacher(@Validated @RequestBody TeacherRequestDTO teacherRequestDTO) {
        return ResponseEntity.ok(teacherService.addTeacher(teacherRequestDTO));
    }

    @GetMapping
    public ResponseEntity<List<TeacherResponseDTO>> getAllTeacher() {
        return ResponseEntity.ok(teacherService.getAllTeachers());
    }

    @GetMapping("/{teacherId}")
    public ResponseEntity<TeacherResponseDTO> getAllTeacher(@PathVariable Long teacherId) {
        return ResponseEntity.ok(teacherService.getOneTeacher(teacherId));
    }
}
