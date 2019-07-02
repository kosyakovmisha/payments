package com.dev.payments;

import com.dev.payments.model.category.Category;
import com.dev.payments.model.client.Client;
import com.dev.payments.model.payment.Payment;
import com.dev.payments.repository.ClientRepository;
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

    public static void main(String[] args) {

        SpringApplication.run(PaymentsApplication.class, args);

    }

    @Override
    public void run(String... args) {
        //categoryRepository.save(new Category("social"));
        clientRepository.save(
                new Client("Misha", "Gorichev", new BigDecimal("100"),
                        new Payment("Social", "500", new Category("Medicine")),
                        new Payment("Medicine", "1000", new Category("Social")))
        );

    }


}
