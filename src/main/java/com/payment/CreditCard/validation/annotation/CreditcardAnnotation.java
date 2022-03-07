package com.payment.CreditCard.validation.annotation;

import com.payment.CreditCard.validation.CreditCardValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CreditCardValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CreditcardAnnotation {

    String message() default "Invalid Credit Card passed in Request, please check request.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}