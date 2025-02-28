package com.learning.Student_Management_System.dto.group;

import com.learning.Student_Management_System.entity.Period;
import com.learning.Student_Management_System.enums.Day;
import lombok.Builder;

import java.time.LocalTime;

@Builder
public record PeriodResponseDTO(
        Long id,
        Day day,
        LocalTime startDate
) {
    public static PeriodResponseDTO makeDTOFromPeriod(Period period) {
        return PeriodResponseDTO.builder()
                .id(period.getId())
                .day(period.getDay())
                .startDate(period.getStartDate())
                .build();
    }
}