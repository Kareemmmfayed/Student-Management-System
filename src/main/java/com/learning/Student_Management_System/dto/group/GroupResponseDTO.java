package com.learning.Student_Management_System.dto.group;

import com.learning.Student_Management_System.entity.Group;
import com.learning.Student_Management_System.enums.Grade;
import com.learning.Student_Management_System.enums.Subject;
import lombok.Builder;

@Builder
public record GroupResponseDTO(
        Long id,
        Grade grade,
        Subject subject
) {

    public static GroupResponseDTO makeDTOFromGroup(Group group) {
        return GroupResponseDTO.builder()
                .id(group.getId())
                .grade(group.getGrade())
                .subject(group.getSubject())
                .build();
    }
}