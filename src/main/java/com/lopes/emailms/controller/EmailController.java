package com.lopes.emailms.controller;

import com.lopes.emailms.dto.EmailDTO;
import com.lopes.emailms.model.Email;
import com.lopes.emailms.service.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * The type Email controller.
 */
@AllArgsConstructor
@RestController
@RequestMapping("ms-email")
public class EmailController {

    /**
     * The Email service.
     */
    private final EmailService emailService;


    /**
     * Send email response entity.
     *
     * @param emailDTO the email dto
     * @return the response entity
     */
    @PostMapping("/send")
    public ResponseEntity<Email> sendEmail(@RequestBody @Valid EmailDTO emailDTO) {

        Email email = new Email();
        BeanUtils.copyProperties(emailDTO, email); // Convert DTO to entity
        email = emailService.sendEmail(email);

        return new ResponseEntity<>(email, HttpStatus.CREATED);
    }
}
