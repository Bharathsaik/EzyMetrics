package com.EzyAssignment.backend.repository;

import com.EzyAssignment.backend.model.CampaignData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampaignRepository extends JpaRepository<CampaignData, Long> {
    // You can define custom query methods here if needed
}