package com.learning.Student_Management_System.dto.group;

import com.learning.Student_Management_System.entity.Group;
import com.learning.Student_Management_System.entity.Period;
import com.learning.Student_Management_System.enums.Grade;
import com.learning.Student_Management_System.enums.Subject;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

@Builder
public record GroupResponseDTO(
        Long id,
        Grade grade,
        Subject subject,
        List<PeriodResponseDTO> periods
) {

    public static GroupResponseDTO makeDTOFromGroup(Group group) {
        List<PeriodResponseDTO> studentPeriods = new ArrayList<>();

        for(Period period : group.getPeriods()) {
            studentPeriods.add(PeriodResponseDTO.makeDTOFromPeriod(period));
        }

        return GroupResponseDTO.builder()
                .id(group.getId())
                .grade(group.getGrade())
                .subject(group.getSubject())
                .periods(studentPeriods)
                .build();
    }
}