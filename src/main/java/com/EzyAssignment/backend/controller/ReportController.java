package com.EzyAssignment.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.EzyAssignment.backend.service.DataService;
import com.EzyAssignment.backend.model.CampaignData;

import java.util.List;

@RestController
@RequestMapping("/api/campaigns")
public class ReportController {

    @Autowired
    private DataService dataService;

    @GetMapping
    public List<CampaignData> getAllCampaigns() {
        return dataService.getAllCampaigns();
    }

    @PostMapping
    public CampaignData createCampaign(@RequestBody CampaignData campaign) {
        return dataService.saveCampaign(campaign);
    }
}
