package com.lopes.emailms.service;

import com.lopes.emailms.model.Email;
import com.lopes.emailms.repository.EmailRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmailService {

    private final EmailRepository emailRepository;

    public void sendEmail(Email email) {
        emailRepository.save(email);
    }

}
