package com.learning.Student_Management_System.service.Impl;

import com.learning.Student_Management_System.dto.student.AttendStudentDTO;
import com.learning.Student_Management_System.dto.student.AttendanceRequestDTO;
import com.learning.Student_Management_System.dto.student.AttendanceResponseDTO;
import com.learning.Student_Management_System.entity.Attendance;
import com.learning.Student_Management_System.entity.Group;
import com.learning.Student_Management_System.entity.Student;
import com.learning.Student_Management_System.exception.ResourceNotFoundException;
import com.learning.Student_Management_System.exception.StudentNotInGroup;
import com.learning.Student_Management_System.repository.AttendanceRepository;
import com.learning.Student_Management_System.repository.GroupRepository;
import com.learning.Student_Management_System.repository.StudentRepository;
import com.learning.Student_Management_System.service.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AttendanceServiceImpl implements AttendanceService {

    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;
    private final AttendanceRepository attendanceRepository;

    @Override
    public List<AttendanceResponseDTO> getAttendance(AttendanceRequestDTO attendanceRequestDTO, Long groupId) {
        Group group = findGroupById(groupId);

        List<Attendance> attendances = attendanceRepository.findByDateAndGroup(attendanceRequestDTO.date(), group);

        Set<Long> attendedStudentIds = attendances.stream()
                .map(attendance -> attendance.getStudent().getId())
                .collect(Collectors.toSet());

        return studentRepository.findAllWithGroup(group).stream()
                .map(student -> AttendanceResponseDTO.builder()
                        .id(student.getId())
                        .firstName(student.getFirstName())
                        .lastName(student.getLastName())
                        .phoneNumber(student.getPhoneNumber())
                        .attended(attendedStudentIds.contains(student.getId()))
                        .build())
                .toList();
    }

    @Override
    @Transactional
    public String attendStudent(Long studentId, Long groupId, AttendStudentDTO attendStudentDTO) {
        Student student = findStudentById(studentId);
        Group group = findGroupById(groupId);

        if(!checkIfStudentIsInGroup(student, group)) throw new StudentNotInGroup("Student with id : [ " + studentId + " ] is not in the Group with id : [ " + groupId + " ]");

        student.attendStudent(
                Attendance.builder()
                        .lessonDate(attendStudentDTO.attendedAt())
                        .student(student)
                        .group(group)
                .build());

        studentRepository.save(student);

        return "Student attendance added successfully!";
    }

    @Override
    public String deleteAttendance(Long attendanceId) {
        attendanceRepository.deleteById(attendanceId);
        return "Attendance deleted successfully!";
    }

    private Boolean checkIfStudentIsInGroup(Student student, Group group) {
        List<Group> groups = student.getGroups();
        return groups.contains(group);
    }

    private Group findGroupById(Long groupId) {
        return groupRepository.findById(groupId).orElseThrow(() -> new ResourceNotFoundException("Group with id : [ " + groupId + " ] is not found!"));
    }

    private Student findStudentById(Long studentId) {
        return studentRepository.findById(studentId).orElseThrow(() -> new ResourceNotFoundException("Student with id : [ " + studentId + " ] is not found!"));
    }
}
