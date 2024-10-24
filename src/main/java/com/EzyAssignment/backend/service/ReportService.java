package com.EzyAssignment.backend.service;

import com.EzyAssignment.backend.model.EmailRequest;
import com.EzyAssignment.backend.model.LeadData;
import com.EzyAssignment.backend.repository.LeadRepository;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportService {

    @Autowired
    private EmailService emailService;
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private LeadRepository leadRepository;



    public void generatePdfAndSendEmail(String letter, String email) {
        // Fetch data based on starting letter from the database
        List<LeadData> leads = leadRepository.findAll()
                .stream()
                .filter(lead -> lead.getName().toLowerCase().startsWith(letter.toLowerCase()))
                .collect(Collectors.toList());

        // Create PDF
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Document pdfDoc = new Document();

        try {
            PdfWriter.getInstance(pdfDoc, byteArrayOutputStream);
            pdfDoc.open();

            pdfDoc.add(new Paragraph("Leads Report - Names starting with " + letter));
            pdfDoc.add(new Paragraph(" "));

            for (LeadData lead : leads) {
                pdfDoc.add(new Paragraph("Name: " + lead.getName() + ", Email: " + lead.getEmail()));
            }

            pdfDoc.close();

        } catch (DocumentException e) {
            e.printStackTrace();
        }

        // Send PDF via email
        ByteArrayInputStream pdfInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());

        try {
            emailService.sendEmailWithAttachment(email, "Leads Report",
                    "Here is the report of leads whose names start with " + letter, pdfInputStream);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    public void sendEmail(EmailRequest emailRequest) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(emailRequest.getTo());
        message.setSubject(emailRequest.getSubject());
        message.setText(emailRequest.getBody());
        mailSender.send(message);
    }

    public String generatePDFReport() {
        // Logic to generate PDF report
        return "PDF Report generated successfully.";
    }

    public String generateCSVReport() {
        // Logic to generate CSV report
        return "CSV Report generated successfully.";
    }




}
