package com.learning.Student_Management_System.repository;

import com.learning.Student_Management_System.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {}