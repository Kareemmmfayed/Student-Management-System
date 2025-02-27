package com.learning.Student_Management_System.repository;

import com.learning.Student_Management_System.entity.Group;
import com.learning.Student_Management_System.enums.Grade;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

    @Query("SELECT g FROM Group g WHERE grade = ?1")
    List<Group> findAllWithGrade(Grade grade, Pageable pageable);
}