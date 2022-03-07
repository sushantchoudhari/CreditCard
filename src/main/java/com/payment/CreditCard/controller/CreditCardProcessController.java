package com.payment.CreditCard.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.payment.CreditCard.domain.Creditcard;
import com.payment.CreditCard.exception.DataAcessException;
import com.payment.CreditCard.service.CreditCardProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * The Credit Card Controller Class. It provides 2 API to Save and retrieve data. Please refer swagger
 * documentation for more details
 */
@RestController
@RequestMapping("/credit-card")
public class CreditCardProcessController {

    @Autowired
    CreditCardProcessService creditCardProcessService;

    //"Add" will create a new credit card for a given name, card number, and limit
    @PostMapping(path = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity addCard(@Valid @RequestBody Creditcard creditcard) throws DataAcessException {
        Creditcard creditcardSaved;
        try {
            creditcardSaved = creditCardProcessService.save(creditcard);
        }catch (Exception exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Credit card is already Present:-  "+creditcard.getCardNumber());
        }
        return ResponseEntity.ok().body(creditcardSaved);
    }

    @GetMapping(path = "/", produces = "application/json")
    public List<Creditcard> getAll() throws JsonProcessingException {
        return creditCardProcessService.getAll();
    }
}