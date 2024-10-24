package com.EzyAssignment.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.EzyAssignment.backend.model.CampaignData;
import com.EzyAssignment.backend.repository.CampaignRepository;

@Service
public class CampaignService {

    @Autowired
    private CampaignRepository campaignRepository;

    public List<CampaignData> getAllCampaigns() {
        return campaignRepository.findAll();
    }

    public CampaignData saveCampaign(CampaignData campaign) {
        return campaignRepository.save(campaign);
    }
}
