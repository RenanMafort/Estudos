package com.sereia.renan.hrpayroll.hrpayroll.services;

import com.sereia.renan.hrpayroll.hrpayroll.entities.Payment;
import com.sereia.renan.hrpayroll.hrpayroll.entities.Worker;
import com.sereia.renan.hrpayroll.hrpayroll.feignclients.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class PaymentService {
//    @Value("${hr-worker.host:NOTFOUND}") ESTAMOS UTILIZANDO AGORA O FEIGN
//    private String workerHost;

//    @Autowired  ESTAMOS UTILIZANDO AGORA O FEIGN
//    private RestTemplate restTemplate;

    // UTILIZANDO O REST TEMPLATE
//    public Payment getPayment(Long workerId, Integer day){
//        Payment payment = null;
//        HashMap<String, String> id = new HashMap<>();
//        id.put("id", workerId.toString());
//        Worker worker = restTemplate.getForObject(workerHost+ "/workers/{id}", Worker.class, id);
//        if (worker != null){
//             payment = new Payment(worker.getName(), worker.getDailyIncome(), day);
//        }
//        return payment;
//    }
    
    @Autowired
    private WorkerFeignClient feignClient;

    public Payment getPayment(Long workerId, Integer day){
        Payment payment = null;
        Worker worker = feignClient.findById(workerId).getBody();
        if (worker != null){
            payment = new Payment(worker.getName(), worker.getDailyIncome(), day);
        }
        return payment;
    }
}
