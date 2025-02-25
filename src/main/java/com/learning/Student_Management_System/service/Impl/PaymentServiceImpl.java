package com.learning.Student_Management_System.service.Impl;

import com.learning.Student_Management_System.dto.student.PaymentRequestDTO;
import com.learning.Student_Management_System.service.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public String addPayment(Long studentId, PaymentRequestDTO paymentRequestDTO) {
        return "";
    }
}