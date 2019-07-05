package com.dev.payments.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public List<Payment> getAll() {
        return paymentRepository.findAll();
    }

    public Payment getById(int id) {
        return paymentRepository.findById(id).orElse(null);
    }

    public Payment getByName(String name) {
        return paymentRepository.findByName(name).orElse(null);
    }
}
