package com.varija.email_tracker.controller;

import com.varija.email_tracker.entity.Email;
import com.varija.email_tracker.service.EmailService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EmailController.class)
@Import(EmailControllerTest.TestConfig.class)  // Import config with mock bean
public class EmailControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private EmailService emailService;  // injected mock from config

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddEmail() throws Exception {
        Email email = new Email();
        email.setRecipient("test@example.com");
        email.setStatus("SENT");

        given(emailService.addEmail(any(Email.class))).willReturn(email);

        mockMvc.perform(post("/emails")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(email)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.recipient").value("test@example.com"))
                .andExpect(jsonPath("$.status").value("SENT"));
    }

    @Test
    public void testGetAllEmails() throws Exception {
        Email email1 = new Email();
        email1.setRecipient("a@example.com");
        Email email2 = new Email();
        email2.setRecipient("b@example.com");

        given(emailService.getAllEmails()).willReturn(List.of(email1, email2));

        mockMvc.perform(get("/emails"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].recipient").value("a@example.com"))
                .andExpect(jsonPath("$[1].recipient").value("b@example.com"));
    }

    @Test
    public void testGetEmailsByStatus() throws Exception {
        Email email = new Email();
        email.setRecipient("status@example.com");
        email.setStatus("OPENED");

        given(emailService.getEmailsByStatus("OPENED")).willReturn(List.of(email));

        mockMvc.perform(get("/emails/status/OPENED"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].recipient").value("status@example.com"))
                .andExpect(jsonPath("$[0].status").value("OPENED"));
    }

    // Test configuration class to provide the mock bean for EmailService
    @Configuration
    static class TestConfig {
        @Bean
        public EmailService emailService() {
            return org.mockito.Mockito.mock(EmailService.class);
        }
    }
}

