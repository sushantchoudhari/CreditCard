package com.payment.CreditCard.repository;

import com.payment.CreditCard.domain.Creditcard;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;

public interface CreditCardRepository extends CrudRepository<Creditcard, BigDecimal> {
}
