package com.dev.payments;

import com.dev.payments.model.category.Category;
import com.dev.payments.model.client.Client;
import com.dev.payments.model.payment.Payment;
import com.dev.payments.repository.CategoryRepository;
import com.dev.payments.repository.ClientRepository;
import com.dev.payments.repository.PaymentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;


@Slf4j
@SpringBootApplication
public class PaymentsApplication implements CommandLineRunner {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    public static void main(String[] args) {

        SpringApplication.run(PaymentsApplication.class, args);

    }

    @Override
    public void run(String... args) {

    }


}
