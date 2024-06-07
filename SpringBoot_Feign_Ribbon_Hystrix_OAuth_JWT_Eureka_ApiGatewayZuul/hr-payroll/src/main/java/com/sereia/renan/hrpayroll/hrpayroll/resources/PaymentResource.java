package com.sereia.renan.hrpayroll.hrpayroll.resources;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sereia.renan.hrpayroll.hrpayroll.entities.Payment;
import com.sereia.renan.hrpayroll.hrpayroll.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {

    private final PaymentService service;

    @Autowired
    public PaymentResource(PaymentService service){
        this.service = service;
    }

    @HystrixCommand(fallbackMethod = "getPaymentAlternative")
    @GetMapping(value = "/{workerId}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable Long workerId,@PathVariable Integer days){
        return ResponseEntity.ok(service.getPayment(workerId,days));
    }

    public ResponseEntity<Payment> getPaymentAlternative(Long workerId, Integer days){
        Payment py = new Payment("Renan Alternative",300.00,days);
        return ResponseEntity.ok(py);
    }
}
