package com.learning.Student_Management_System.service.Impl;

import com.learning.Student_Management_System.dto.student.*;
import com.learning.Student_Management_System.enums.Grade;
import com.learning.Student_Management_System.entity.Group;
import com.learning.Student_Management_System.entity.Student;
import com.learning.Student_Management_System.exception.ResourceNotFoundException;
import com.learning.Student_Management_System.exception.StudentNotSuitableForGroupException;
import com.learning.Student_Management_System.repository.GroupRepository;
import com.learning.Student_Management_System.repository.StudentRepository;
import com.learning.Student_Management_System.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;

    @Override
    @Transactional
    public OneStudentResponseDTO addStudent(StudentRequestDTO studentRequestDTO) {
        return OneStudentResponseDTO.makeStudentResponseDTOFromStudent(
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
    public List<StudentResponseDTO> getStudents(YearMonth monthDate, Grade grade) {
        if(grade == null) return getAllStudents(monthDate);

        return getAllStudentsInAGrade(monthDate, grade);
    }

    private List<StudentResponseDTO> getAllStudentsInAGrade(YearMonth monthDate, Grade grade) {
        List<Student> students = studentRepository.findAllWithGrade(grade);

        return checkIfStudentPaidThatMonth(students, monthDate);
    }

    private List<StudentResponseDTO> getAllStudents(YearMonth monthDate) {
        List<Student> students = studentRepository.findAll();

        return checkIfStudentPaidThatMonth(students, monthDate);
    }

    private List<StudentResponseDTO> checkIfStudentPaidThatMonth(List<Student> students, YearMonth monthDate) {
        List<StudentResponseDTO> results = new ArrayList<>();

        for (Student student : students) {
            boolean didPay = false;
            for (PaymentRequestDTO payment : student.getPayments().stream().map(PaymentRequestDTO::makeDTOFromPayment).toList()) {
                if (payment.paidAt().equals(monthDate)) {
                    didPay = true;
                    break;
                }
            }

            results.add(StudentResponseDTO.builder()
                    .id(student.getId())
                    .firstName(student.getFirstName())
                    .lastName(student.getLastName())
                    .phoneNumber(student.getPhoneNumber())
                    .grade(student.getGrade())
                    .paid(didPay)
                    .build());
        }

        return results;
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
        return groupRepository.findById(groupId).orElseThrow(() -> new ResourceNotFoundException("Group with id : [" + groupId + "] doesn't exist!"));
    }
}
