package com.payment.CreditCard.validation;

import com.payment.CreditCard.validation.annotation.CreditcardAnnotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.function.IntUnaryOperator;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class CreditCardValidator implements ConstraintValidator<CreditcardAnnotation, String> {

    public static final int CREDIT_CARD_LENGTH = 19;
    public static final String DIGIT_REGEX = "\\d+";


    @Override
    public void initialize(CreditcardAnnotation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String creditCardNumber, ConstraintValidatorContext constraintValidatorContext) {
        if (creditCardNumber == null
                || creditCardNumber.length() > CREDIT_CARD_LENGTH
                || !Pattern.compile(DIGIT_REGEX).matcher(creditCardNumber).matches()) {
            return false;
        }
        return checkLuhnTen(creditCardNumber);
    }

    public static boolean checkLuhnTen(String s) {
        IntUnaryOperator sumDigits = n -> n / 10 + n % 10;
        var digits = s.chars()
                .map(Character::getNumericValue)
                .toArray();
        return IntStream.rangeClosed(1, digits.length)
                .map(i -> digits.length - i)
                .map(i -> i % 2 == 0 ? digits[i] : sumDigits.applyAsInt(digits[i] * 2))
                .sum() % 10 == 0;
    }
}
