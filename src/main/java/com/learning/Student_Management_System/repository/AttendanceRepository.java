package com.learning.Student_Management_System.repository;

import com.learning.Student_Management_System.entity.Attendance;
import com.learning.Student_Management_System.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    @Query("SELECT a FROM Attendance a WHERE a.lessonDate = ?1 AND a.group = ?2")
    List<Attendance> findByDateAndGroup(LocalDate date, Group group);
}