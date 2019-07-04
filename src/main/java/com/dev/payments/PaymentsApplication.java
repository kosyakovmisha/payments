package com.dev.payments;

import com.dev.payments.category.Category;
import com.dev.payments.category.CategoryService;
import com.dev.payments.client.Client;
import com.dev.payments.payment.Payment;
import com.dev.payments.client.ClientRepository;
import com.dev.payments.payment.PaymentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;


@Slf4j
@SpringBootApplication
public class PaymentsApplication implements CommandLineRunner {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private PaymentRepository paymentRepository;

    public static void main(String[] args) {

        SpringApplication.run(PaymentsApplication.class, args);

    }

    @Transactional
    @Override
    public void run(String... args) {

    }

    public void startedTest() {
        Category medicine = new Category("medicine");
        Category social = new Category("social");
        Category tax = new Category("tax");

        Payment brainFix = new Payment("brainFix", "100", medicine);
        Payment handsFix = new Payment("handsFix", "50", medicine);
        Payment eyesFix = new Payment("eyesFix", "110", medicine);
        Payment kompi = new Payment("kompi", "10", social);
        Payment driving = new Payment("driving", "25", social);
        Payment homeTax = new Payment("homeTax", "300", tax);

        Client misha = new Client("Misha", "Kosyakov", "1000", brainFix, eyesFix, homeTax);
        Client vlad = new Client("Vlad", "Develope", "100000", handsFix, driving, homeTax);
        Client artem = new Client("Artem", "Sikas", "5333", kompi, driving, eyesFix, homeTax);

        clientRepository.save(misha);
        clientRepository.save(vlad);
        clientRepository.save(artem);
    }
}
