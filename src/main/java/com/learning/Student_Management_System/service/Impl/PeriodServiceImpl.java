package com.learning.Student_Management_System.service.Impl;

import com.learning.Student_Management_System.dto.group.PeriodRequestDTO;
import com.learning.Student_Management_System.dto.group.PeriodResponseDTO;
import com.learning.Student_Management_System.entity.Group;
import com.learning.Student_Management_System.entity.Period;
import com.learning.Student_Management_System.exception.ResourceNotFoundException;
import com.learning.Student_Management_System.repository.GroupRepository;
import com.learning.Student_Management_System.service.PeriodService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PeriodServiceImpl implements PeriodService {

    private final GroupRepository groupRepository;

    @Override
    @Transactional
    public String addPeriod(Long groupId, PeriodRequestDTO periodRequestDTO) {
        Group group = findGroupById(groupId);

        group.addPeriod(Period.builder()
                .day(periodRequestDTO.day())
                .startDate(periodRequestDTO.startDate())
                .group(group)
                .build());

        groupRepository.save(group);

        return "Period added successfully!";
    }

    private Group findGroupById(Long groupId) {
        return groupRepository.findById(groupId).orElseThrow(() -> new ResourceNotFoundException("Group with id : [" + groupId + "] is not found!"));
    }
}
