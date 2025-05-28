package com.varija.email_tracker.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.varija.email_tracker.entity.Email;
import com.varija.email_tracker.kafka.EmailStatusProducer;
import com.varija.email_tracker.repository.EmailRepository;

public class EmailServiceTest {
 @Mock
    private EmailRepository emailRepository;

    @Mock
    private EmailStatusProducer emailStatusProducer;

    @InjectMocks
    private EmailService emailService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddEmail_ShouldSaveAndReturnEmail() {
        Email email = new Email();
        email.setRecipient("test@example.com");
        email.setStatus("SENT");

        when(emailRepository.save(email)).thenReturn(email);

        Email result = emailService.addEmail(email);

        assertNotNull(result);
        assertEquals("test@example.com", result.getRecipient());

        verify(emailRepository, times(1)).save(email);
    }

    @Test
    public void testGetAllEmails_ShouldReturnList() {
        Email email1 = new Email();
        email1.setRecipient("a@example.com");
        Email email2 = new Email();
        email2.setRecipient("b@example.com");

        when(emailRepository.findAll()).thenReturn(List.of(email1, email2));

        List<Email> emails = emailService.getAllEmails();

        assertEquals(2, emails.size());
        verify(emailRepository, times(1)).findAll();
    }

    @Test
    public void testGetEmailsByStatus_ShouldReturnFilteredList() {
        Email email = new Email();
        email.setRecipient("filter@example.com");
        email.setStatus("OPENED");

        when(emailRepository.findByStatus("OPENED")).thenReturn(List.of(email));

        List<Email> emails = emailService.getEmailsByStatus("OPENED");

        assertEquals(1, emails.size());
        assertEquals("filter@example.com", emails.get(0).getRecipient());

        verify(emailRepository, times(1)).findByStatus("OPENED");
    }
}
