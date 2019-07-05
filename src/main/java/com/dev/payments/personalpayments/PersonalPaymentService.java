package com.dev.payments.personalpayments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonalPaymentService {

    @Autowired
    private PersonalPaymentRepository personalPaymentRepository;


}
