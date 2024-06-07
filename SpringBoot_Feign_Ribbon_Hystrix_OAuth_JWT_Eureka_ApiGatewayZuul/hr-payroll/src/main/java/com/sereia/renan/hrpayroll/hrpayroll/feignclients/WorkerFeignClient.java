package com.sereia.renan.hrpayroll.hrpayroll.feignclients;

import com.sereia.renan.hrpayroll.hrpayroll.entities.Worker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
//@FeignClient(name = "hr-worker", url = "http://localhost:8001", path = "/workers")
@FeignClient(name = "hr-worker", path = "/workers") // agora estamos usando o Eureka
public interface WorkerFeignClient {

    @GetMapping(value = "/{id}")
    ResponseEntity<Worker> findById(@PathVariable Long id);

}
