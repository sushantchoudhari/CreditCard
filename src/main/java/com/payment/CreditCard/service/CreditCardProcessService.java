package com.payment.CreditCard.service;

import com.payment.CreditCard.domain.Creditcard;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CreditCardProcessService {

    Creditcard save(Creditcard paymentCard);

    List<Creditcard> getAll();
}
