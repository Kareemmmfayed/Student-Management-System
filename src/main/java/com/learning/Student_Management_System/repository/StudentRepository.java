package com.learning.Student_Management_System.repository;

import com.learning.Student_Management_System.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {}