package com.learning.Student_Management_System.repository;

import com.learning.Student_Management_System.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {}