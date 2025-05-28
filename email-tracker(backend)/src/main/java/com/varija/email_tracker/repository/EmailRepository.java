package com.varija.email_tracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.varija.email_tracker.entity.Email;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {
    List<Email> findByStatus(String status);
}
