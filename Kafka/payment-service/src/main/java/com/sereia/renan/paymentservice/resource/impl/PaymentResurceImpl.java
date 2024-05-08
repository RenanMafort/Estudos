package com.sereia.renan.paymentservice.resource.impl;

import com.sereia.renan.paymentservice.model.Payment;
import com.sereia.renan.paymentservice.resource.PaymetnResource;
import com.sereia.renan.paymentservice.servicecs.PaymentServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/payments")
public class PaymentResurceImpl implements PaymetnResource {

    private final PaymentServices paymentServices;

    @Override
    public ResponseEntity<Payment> payment(Payment payment) {
        paymentServices.sendPayment(payment);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
