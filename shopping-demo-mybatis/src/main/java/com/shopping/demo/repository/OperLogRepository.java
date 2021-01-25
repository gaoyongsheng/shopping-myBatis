package com.shopping.demo.repository;

import com.shopping.demo.entity.OperLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperLogRepository extends JpaRepository<OperLog, Long> {

  
}
