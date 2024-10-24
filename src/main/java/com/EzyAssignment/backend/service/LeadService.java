package com.EzyAssignment.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.EzyAssignment.backend.model.LeadData;
import com.EzyAssignment.backend.repository.LeadRepository;

@Service
public class LeadService {

    @Autowired
    private LeadRepository leadRepository;

    public List<LeadData> getAllLeads() {
        return leadRepository.findAll();
    }

    public LeadData saveLead(LeadData lead) {
        return leadRepository.save(lead);
    }
}
