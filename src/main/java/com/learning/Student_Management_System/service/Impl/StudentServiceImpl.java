package com.learning.Student_Management_System.service.Impl;

import com.learning.Student_Management_System.dto.student.StudentRequestDTO;
import com.learning.Student_Management_System.dto.student.StudentResponseDTO;
import com.learning.Student_Management_System.enums.Grade;
import com.learning.Student_Management_System.entity.Group;
import com.learning.Student_Management_System.entity.Student;
import com.learning.Student_Management_System.exception.GroupNotFoundException;
import com.learning.Student_Management_System.exception.StudentNotSuitableForGroupException;
import com.learning.Student_Management_System.repository.GroupRepository;
import com.learning.Student_Management_System.repository.StudentRepository;
import com.learning.Student_Management_System.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;

    @Override
    @Transactional
    public StudentResponseDTO addStudent(StudentRequestDTO studentRequestDTO) {
        return StudentResponseDTO.makeStudentResponseDTOFromStudent(
                studentRepository.save(
                Student.builder()
                        .firstName(studentRequestDTO.firstName())
                        .lastName(studentRequestDTO.lastName())
                        .phoneNumber(studentRequestDTO.phoneNumber())
                        .address(studentRequestDTO.address())
                        .groups(makeStudentGroups(studentRequestDTO.groupId(), studentRequestDTO.grade()))
                        .grade(studentRequestDTO.grade())
                        .isActive(true)
                        .build()
        ));
    }

    @Override
    @Transactional
    public List<StudentResponseDTO> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(StudentResponseDTO::makeStudentResponseDTOFromStudent)
                .collect(Collectors.toList());
    }

    private Group checkIfStudentGradeIsSuitableForGroup(Group group, Grade grade) {
        if(group.getGrade() != grade) {
            throw new StudentNotSuitableForGroupException("The Student is not in the same grade as the group!");
        }

        return group;
    }

    private List<Group> makeStudentGroups(Long groupId, Grade grade) {
        List<Group> groups = new ArrayList<>();
        groups.add(checkIfStudentGradeIsSuitableForGroup(findGroupById(groupId), grade));
        return groups;
    }

    private Group findGroupById(Long groupId) {
        return groupRepository.findById(groupId).orElseThrow(() -> new GroupNotFoundException("Group with id : [" + groupId + "] doesn't exist!"));
    }
}
