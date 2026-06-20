package com.vivek.gympulse.service;

import com.vivek.gympulse.entity.Payment;
import com.vivek.gympulse.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public Payment savePayment(Payment payment) {
        return paymentRepository.save(payment);
    }
    public List<Payment> getPaymentsByMember(Long memberId) {
        return paymentRepository.findByMemberId(memberId);
    }
}