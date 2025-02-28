package com.learning.Student_Management_System.service;

import com.learning.Student_Management_System.dto.group.PeriodRequestDTO;

public interface PeriodService {
    String addPeriod(Long groupId, PeriodRequestDTO periodRequestDTO);
}