package com.payment.CreditCard.service;

import com.payment.CreditCard.domain.Creditcard;
import com.payment.CreditCard.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditCardProcessServiceImpl implements  CreditCardProcessService{

    @Autowired
    CreditCardRepository creditCardRepository;

    public Creditcard save(Creditcard paymentCard) {
        return creditCardRepository.save(paymentCard);
    }

    public List<Creditcard> getAll() {
        return (List<Creditcard>) creditCardRepository.findAll();
    }

}
