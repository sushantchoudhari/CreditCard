package com.payment.CreditCard.domain;

import com.payment.CreditCard.validation.annotation.CreditcardAnnotation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Creditcard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotBlank(message = "userName cannot be blank")
    @NotNull
    private String userName;


    @Column(unique = true)
    @CreditcardAnnotation
    private String cardNumber;

    @NotNull
    @Digits(integer = 9, fraction = 2)
    private BigDecimal cardLimit;

    @Digits(integer = 10, fraction = 2)
    private BigDecimal accountBalance = BigDecimal.valueOf(0.0);
}
