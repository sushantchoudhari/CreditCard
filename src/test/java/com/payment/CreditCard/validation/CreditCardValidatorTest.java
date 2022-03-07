package com.payment.CreditCard.validation;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.validation.ConstraintValidatorContext;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


@ExtendWith(MockitoExtension.class)
public class CreditCardValidatorTest {

    @Mock
    ConstraintValidatorContext constraintValidatorContext;

    @InjectMocks
    CreditCardValidator creditCardValidator;

    @Test
    public void valid_creditcard() {
        final String correctCreditCardNumber = "4407392041873274552";
        final boolean got =
                creditCardValidator.isValid(correctCreditCardNumber, constraintValidatorContext);
        assertTrue(got);
    }

    @Test
    public void invalid_luhn10_creditcard() {
        final String incorrectCrediCardNumber = "4407392041873274553";
        final boolean got =
                creditCardValidator.isValid(incorrectCrediCardNumber, constraintValidatorContext);
        assertFalse(got);
    }

    @Test
    public void empty_creditcard() {
        final String incorrectCrediCardNumber = "";
        final boolean got =
                creditCardValidator.isValid(incorrectCrediCardNumber, constraintValidatorContext);
        assertFalse(got);
    }

    @Test
    public void null_creditcard() {
        final String incorrectCrediCardNumber = null;
        final boolean got =
                creditCardValidator.isValid(incorrectCrediCardNumber, constraintValidatorContext);
        assertFalse(got);
    }

    @Test
    public void creditcard_length_greater_than_19_() {
        final String incorrectCrediCardNumber = "11223344556677889900";
        final boolean got =
                creditCardValidator.isValid(incorrectCrediCardNumber, constraintValidatorContext);
        assertFalse(got);
    }

    @Test
    public void creditcard_with_alphabets() {
        final String incorrectCrediCardNumber = "12345678912345678uu";
        final boolean got =
                creditCardValidator.isValid(incorrectCrediCardNumber, constraintValidatorContext);
        assertFalse(got);
    }
}