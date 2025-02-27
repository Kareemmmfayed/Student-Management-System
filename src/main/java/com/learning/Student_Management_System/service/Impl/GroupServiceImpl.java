package com.learning.Student_Management_System.service.Impl;

import com.learning.Student_Management_System.dto.group.GroupRequestDTO;
import com.learning.Student_Management_System.dto.group.GroupResponseDTO;
import com.learning.Student_Management_System.entity.Group;
import com.learning.Student_Management_System.enums.Grade;
import com.learning.Student_Management_System.enums.Subject;
import com.learning.Student_Management_System.entity.Teacher;
import com.learning.Student_Management_System.exception.ResourceNotFoundException;
import com.learning.Student_Management_System.exception.TeacherNotSuitableException;
import com.learning.Student_Management_System.repository.GroupRepository;
import com.learning.Student_Management_System.repository.TeacherRepository;
import com.learning.Student_Management_System.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;
    private final TeacherRepository teacherRepository;

    @Override
    public List<GroupResponseDTO> getGroups(Grade grade, int pageNum, int pageSize) {
        if (grade == null) return getAllGroups(pageNum, pageSize);

        return getAllGroupsInAGrade(grade, pageNum, pageSize);
    }

    @Override
    @Transactional
    public Group AddGroup(Long teacherId, GroupRequestDTO groupRequestDTO) {
        return groupRepository.save(
                Group
                        .builder()
                        .subject(groupRequestDTO.subject())
                        .teacher(checkIfTeacherTeachesThisSubject(findSingleTeacherById(teacherId), groupRequestDTO.subject()))
                        .grade(groupRequestDTO.grade())
                        .build()
        );
    }

    private List<GroupResponseDTO> getAllGroupsInAGrade(Grade grade, int pageNum, int pageSize) {
        return groupRepository.findAllWithGrade(grade, PageRequest.of(pageNum, pageSize))
                .stream()
                .map(GroupResponseDTO::makeDTOFromGroup)
                .toList();
    }

    private List<GroupResponseDTO> getAllGroups(int pageNum, int pageSize) {
        return groupRepository.findAll(PageRequest.of(pageNum, pageSize))
                .stream()
                .map(GroupResponseDTO::makeDTOFromGroup)
                .toList();
    }

    private Teacher findSingleTeacherById(Long teacherId) {
        return teacherRepository
                .findById(teacherId)
                .orElseThrow(() -> new ResourceNotFoundException("The teacher with id : [" + teacherId + "] doesn't exit!"));
    }

    private Teacher checkIfTeacherTeachesThisSubject(Teacher teacher, Subject subject) {
        if(teacher.getSubject() != subject) {
            throw new TeacherNotSuitableException("The teacher with id : [" + teacher.getId() + "] doesn't teach this subject!");
        }

        return teacher;
    }
}
