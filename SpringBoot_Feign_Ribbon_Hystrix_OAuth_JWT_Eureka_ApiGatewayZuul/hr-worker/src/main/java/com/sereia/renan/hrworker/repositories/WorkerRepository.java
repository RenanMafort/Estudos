package com.sereia.renan.hrworker.repositories;

import com.sereia.renan.hrworker.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker,Long> {
}
