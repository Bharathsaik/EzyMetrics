package com.EzyAssignment.backend.repository;

import com.EzyAssignment.backend.model.LeadData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeadRepository extends JpaRepository<LeadData, Long> {
    // You can define custom query methods here if needed
    List<LeadData> findByNameStartingWithIgnoreCase(String letter);
}