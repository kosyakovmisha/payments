package com.dev.payments.personalpayments;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalPaymentRepository extends JpaRepository<PersonalPayment, Integer> {
}
