package com.learning.Student_Management_System.service;

import com.learning.Student_Management_System.dto.student.PaymentRequestDTO;

public interface PaymentService {
    String addPayment(Long studentId ,PaymentRequestDTO paymentRequestDTO);
    String deletePayment(Long paymentId);
}
