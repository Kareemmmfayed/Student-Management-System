package com.learning.Student_Management_System.repository;

import com.learning.Student_Management_System.entity.Group;
import com.learning.Student_Management_System.entity.Student;
import com.learning.Student_Management_System.enums.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT s FROM Student s WHERE s.grade = ?1")
    List<Student> findAllWithGrade(Grade grade);

    @Query("SELECT s FROM Student s WHERE ?1 MEMBER OF s.groups")
    List<Student> findAllWithGroup(Group group);
}