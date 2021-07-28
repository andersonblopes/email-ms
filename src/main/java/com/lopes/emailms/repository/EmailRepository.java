package com.lopes.emailms.repository;

import com.lopes.emailms.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Email repository.
 */
public interface EmailRepository extends JpaRepository<Email, Long> {
}
