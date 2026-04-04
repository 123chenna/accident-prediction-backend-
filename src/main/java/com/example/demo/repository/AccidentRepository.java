package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.AccidentData;

public interface AccidentRepository extends JpaRepository<AccidentData, Long> {
}