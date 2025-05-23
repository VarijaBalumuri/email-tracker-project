package com.varija.email_tracker.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.varija.email_tracker.entity.Email;
import com.varija.email_tracker.kafka.EmailStatusProducer;
import com.varija.email_tracker.repository.EmailRepository;

@Service
public class EmailService {

    private final EmailRepository emailRepository;
    private final EmailStatusProducer emailStatusProducer;

    public EmailService(EmailRepository emailRepository, EmailStatusProducer producer) {
        this.emailRepository = emailRepository;
        this.emailStatusProducer = producer;
    }

    public Email addEmail(Email email) {
        Email savedEmail = emailRepository.save(email);

        // Simulate background processing
        new Thread(() -> processEmail(savedEmail)).start();

        return savedEmail;
    }

    public List<Email> getAllEmails() {
        return emailRepository.findAll();
    }

    public List<Email> getEmailsByStatus(String status) {
        return emailRepository.findByStatus(status);
    }

    private void processEmail(Email email) {
    try {
        Thread.sleep(3000); // simulate delay

        Email freshEmail = emailRepository.findById(email.getId()).orElse(null);
        if (freshEmail == null) return;

        // Just send status update without changing the original status
        emailStatusProducer.sendStatusUpdate("Email to " + freshEmail.getRecipient() + " has status: " + freshEmail.getStatus());

    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
    }
}



}