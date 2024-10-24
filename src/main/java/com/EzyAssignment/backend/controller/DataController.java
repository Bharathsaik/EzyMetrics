package com.EzyAssignment.backend.controller;

import com.EzyAssignment.backend.model.EmailRequest;
import com.EzyAssignment.backend.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.EzyAssignment.backend.model.LeadData;
import com.EzyAssignment.backend.service.DataService;

@RestController
@RequestMapping("/api/leads")
public class DataController {

    @Autowired
    private DataService dataService;

    @Autowired
    private EmailService emailService;

    @PostMapping("/send-email")
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest emailRequest) {
        emailService.sendEmail(emailRequest);
        return ResponseEntity.ok("Email sent successfully!");
    }

    // This is where you would add your sendEmailNotification method
    public String sendEmailNotification(String recipient) {
        String subject = "Report Generated";
        String text = "Your report has been successfully generated.";

        // Create EmailRequest object
        EmailRequest emailRequest = new EmailRequest();
        emailRequest.setTo(recipient);
        emailRequest.setSubject(subject);
        emailRequest.setBody(text);

        // Send email
        emailService.sendEmail(emailRequest);
        return "Email notification sent to " + recipient;
    }

    @GetMapping
    public List<LeadData> getAllLeads() {
        return dataService.getAllLeads();
    }

    @PostMapping
    public LeadData createLead(@RequestBody LeadData lead) {
        return dataService.saveLead(lead);
    }
}
