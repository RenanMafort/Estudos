package com.sereia.renan.paymentservice.resource;

import com.sereia.renan.paymentservice.model.Payment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface PaymetnResource {

    @PostMapping
    ResponseEntity<Payment> payment (@RequestBody Payment payment);
}
