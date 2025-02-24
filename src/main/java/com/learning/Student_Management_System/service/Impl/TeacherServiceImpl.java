package com.learning.Student_Management_System.service.Impl;

import com.learning.Student_Management_System.dto.teacher.TeacherRequestDTO;
import com.learning.Student_Management_System.entity.Teacher;
import com.learning.Student_Management_System.repository.TeacherRepository;
import com.learning.Student_Management_System.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    @Override
    @Transactional
    public Teacher addTeacher(TeacherRequestDTO teacherRequestDTO) {
        return teacherRepository.save(
                Teacher.builder()
                        .firstName(teacherRequestDTO.firstName())
                        .lastName(teacherRequestDTO.lastName())
                        .phoneNumber(teacherRequestDTO.phoneNumber())
                        .email(teacherRequestDTO.email())
                        .address(teacherRequestDTO.address())
                        .subject(teacherRequestDTO.subject())
                .build()
        );
    }
}
