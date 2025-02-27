package com.learning.Student_Management_System.controller;

import com.learning.Student_Management_System.dto.group.GroupRequestDTO;
import com.learning.Student_Management_System.dto.group.GroupResponseDTO;
import com.learning.Student_Management_System.entity.Group;
import com.learning.Student_Management_System.enums.Grade;
import com.learning.Student_Management_System.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;

    @GetMapping
    public ResponseEntity<List<GroupResponseDTO>> getGroups(
            @RequestParam(name = "grade", required = false) Grade grade,
            @RequestParam(name = "pageNum", required = true) int pageNum,
            @RequestParam(name = "pageSize", required = true) int pageSize
    ) {
        return ResponseEntity.ok(groupService.getGroups(grade, pageNum, pageSize));
    }

    @PostMapping("/{teacherId}")
    public ResponseEntity<Group> addGroup(@PathVariable Long teacherId, @RequestBody GroupRequestDTO groupRequestDTO) {
        return ResponseEntity.ok(groupService.AddGroup(teacherId ,groupRequestDTO));
    }
}
