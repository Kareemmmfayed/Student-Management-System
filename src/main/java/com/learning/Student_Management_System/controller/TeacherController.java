package com.learning.Student_Management_System.controller;

import com.learning.Student_Management_System.dto.teacher.TeacherRequestDTO;
import com.learning.Student_Management_System.entity.Teacher;
import com.learning.Student_Management_System.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teachers")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @PostMapping
    public ResponseEntity<Teacher> addTeacher(@Validated @RequestBody TeacherRequestDTO teacherRequestDTO) {
        return ResponseEntity.ok(teacherService.addTeacher(teacherRequestDTO));
    }
}
