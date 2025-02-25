package com.learning.Student_Management_System.controller;

import com.learning.Student_Management_System.dto.group.GroupRequestDTO;
import com.learning.Student_Management_System.entity.Group;
import com.learning.Student_Management_System.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/groups")
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;

    @PostMapping
    public ResponseEntity<Group> addGroup(@RequestBody GroupRequestDTO groupRequestDTO) {
        return ResponseEntity.ok(groupService.AddGroup(groupRequestDTO));
    }
}
