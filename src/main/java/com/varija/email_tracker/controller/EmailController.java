package com.varija.email_tracker.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.varija.email_tracker.entity.Email;
import com.varija.email_tracker.service.EmailService;

@RestController
@RequestMapping("/emails")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping
    public ResponseEntity<Email> addEmail(@RequestBody Email email) {
        return ResponseEntity.ok(emailService.addEmail(email));
    }

    @GetMapping
    public List<Email> getAllEmails() {
        return emailService.getAllEmails();
    }

    @GetMapping("/status/{status}")
    public List<Email> getEmailsByStatus(@PathVariable String status) {
        return emailService.getEmailsByStatus(status);
    }

}
