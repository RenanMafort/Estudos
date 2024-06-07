package com.sereia.renan.hrworker.resourcer;

import com.sereia.renan.hrworker.entity.Worker;
import com.sereia.renan.hrworker.repositories.WorkerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RefreshScope
@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {
    private static final Logger log = LoggerFactory.getLogger(WorkerResource.class);

    @Value("${test.config}")
    private String testConfig;

    @Autowired
    private Environment environment;
    @Autowired
    private WorkerRepository repository;

    @GetMapping(value = "/configs")
    public ResponseEntity<Void> configs(){
        log.info("##### LOG CONFIG #####: ".concat(testConfig));
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Worker>> findAll(){
        List<Worker> listAll = repository.findAll();
        return ResponseEntity.ok(listAll);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id) throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);

        log.info("PORT:{}", environment.getProperty("local.server.port"));

        Worker worker = repository.findById(id).get();

        return ResponseEntity.ok(worker);
    }
}
