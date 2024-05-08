package com.sereia.renan.paymentservice.servicecs.impl;

import com.sereia.renan.paymentservice.model.Payment;
import com.sereia.renan.paymentservice.servicecs.PaymentServices;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

@Service
@Log4j2
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentServices {

    private final KafkaTemplate<String, Serializable> kafkaTemplate;
    @Override
    @SneakyThrows
    public void sendPayment(Payment payment) {
        log.info("PAYMENT_SERVICE_IMPL ::: Recebi o pagamento {}",payment);
        TimeUnit.SECONDS.sleep(1);
        log.info("Enviando pagamento...");
        kafkaTemplate.send("payment-topic",payment);
    }
}
