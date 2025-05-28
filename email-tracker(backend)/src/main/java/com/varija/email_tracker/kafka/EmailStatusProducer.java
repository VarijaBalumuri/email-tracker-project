package com.varija.email_tracker.kafka;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


@Component
public class EmailStatusProducer {

    @Value("${email-status-topic}")
    private String topic;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public EmailStatusProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendStatusUpdate(String message) {
        kafkaTemplate.send(topic, message);
    }
}
