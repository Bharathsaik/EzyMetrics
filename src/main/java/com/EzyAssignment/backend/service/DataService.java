package com.EzyAssignment.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.EzyAssignment.backend.model.LeadData;
import com.EzyAssignment.backend.model.CampaignData;
import com.EzyAssignment.backend.repository.LeadRepository;
import com.EzyAssignment.backend.repository.CampaignRepository;

@Service
public class DataService {

    @Autowired
    private LeadRepository leadRepository;

    @Autowired
    private CampaignRepository campaignRepository;

    // Fetch all leads
    public List<LeadData> getAllLeads() {
        return leadRepository.findAll();
    }

    // Save a lead
    public LeadData saveLead(LeadData lead) {
        return leadRepository.save(lead);
    }

    // Fetch all campaigns
    public List<CampaignData> getAllCampaigns() {
        return campaignRepository.findAll();
    }

    // Save a campaign
    public CampaignData saveCampaign(CampaignData campaign) {
        return campaignRepository.save(campaign);
    }
}
