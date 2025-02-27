package com.learning.Student_Management_System.service;

import com.learning.Student_Management_System.dto.group.GroupRequestDTO;
import com.learning.Student_Management_System.entity.Group;

public interface GroupService {
    Group AddGroup(Long teacherId,GroupRequestDTO groupRequestDTO);
}
