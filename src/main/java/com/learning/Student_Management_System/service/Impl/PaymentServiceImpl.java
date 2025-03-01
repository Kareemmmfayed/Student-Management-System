package com.learning.Student_Management_System.service.Impl;

import com.learning.Student_Management_System.dto.student.PaymentRequestDTO;
import com.learning.Student_Management_System.entity.Payment;
import com.learning.Student_Management_System.entity.Student;
import com.learning.Student_Management_System.exception.ResourceNotFoundException;
import com.learning.Student_Management_System.repository.PaymentRepository;
import com.learning.Student_Management_System.repository.StudentRepository;
import com.learning.Student_Management_System.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final StudentRepository studentRepository;
    private final PaymentRepository paymentRepository;

    @Override
    @Transactional
    public String addPayment(Long studentId, PaymentRequestDTO paymentRequestDTO) {
        Student student = findSingleStudentById(studentId);

        student.addPayment(Payment.builder()
                .paidAt(paymentRequestDTO.paidAt().atDay(1))
                .student(student)
                .build());

        studentRepository.save(student);
        return "Payment was added successfully";
    }

    @Override
    public String deletePayment(Long paymentId) {
        paymentRepository.deleteById(paymentId);
        return "Payment deleted successfully!";
    }

    private Student findSingleStudentById(Long studentId) {
        return studentRepository.findById(studentId).orElseThrow(() -> new ResourceNotFoundException("Student with id : [" + studentId + "] is not found!"));
    }
}