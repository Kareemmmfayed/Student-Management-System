package com.learning.Student_Management_System.controller;

import com.learning.Student_Management_System.dto.group.GroupRequestDTO;
import com.learning.Student_Management_System.entity.Group;
import com.learning.Student_Management_System.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/groups")
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;

    @PostMapping("/{teacherId}")
    public ResponseEntity<Group> addGroup(@PathVariable Long teacherId, @RequestBody GroupRequestDTO groupRequestDTO) {
        return ResponseEntity.ok(groupService.AddGroup(teacherId ,groupRequestDTO));
    }
}
