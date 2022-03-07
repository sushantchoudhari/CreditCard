package com.payment.CreditCard.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomizedExceptionHandlerResponse {

    private String message;
    private Date timestamp;
    private String status;


}
