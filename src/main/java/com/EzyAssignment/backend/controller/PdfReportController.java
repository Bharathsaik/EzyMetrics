package com.EzyAssignment.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EzyAssignment.backend.service.ReportService;

@RestController
@RequestMapping("/api/reports")
public class PdfReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/generate-pdf")
    public ResponseEntity<String> generateAndSendPdfReport(
            @RequestParam("letter") String letter,
            @RequestParam(value = "email", defaultValue = "konduru.bharathsai1@gmail.com") String email) {

        // Generate PDF report and send it via email
        reportService.generatePdfAndSendEmail(letter, email);

        return new ResponseEntity<>("Report generated and emailed successfully!", HttpStatus.OK);
    }
}
