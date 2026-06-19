package com.vivek.gympulse.repository;

import com.vivek.gympulse.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}