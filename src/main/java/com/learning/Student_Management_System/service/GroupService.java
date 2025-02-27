package com.learning.Student_Management_System.service;

import com.learning.Student_Management_System.dto.group.GroupRequestDTO;
import com.learning.Student_Management_System.dto.group.GroupResponseDTO;
import com.learning.Student_Management_System.entity.Group;
import com.learning.Student_Management_System.enums.Grade;

import java.util.List;

public interface GroupService {
    List<GroupResponseDTO> getGroups(Grade grade, int pageNum, int pageSize);
    Group AddGroup(Long teacherId,GroupRequestDTO groupRequestDTO);
}
