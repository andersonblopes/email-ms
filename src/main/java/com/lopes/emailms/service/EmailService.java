package com.lopes.emailms.service;

import com.lopes.emailms.enumerations.StatusEmail;
import com.lopes.emailms.model.Email;
import com.lopes.emailms.repository.EmailRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * The type Email service.
 */
@Slf4j
@Service
@AllArgsConstructor
public class EmailService {

    /**
     * The Email repository.
     */
    private final EmailRepository emailRepository;

    /**
     * The Mail sender.
     */
    private final JavaMailSender mailSender;

    /**
     * Send email email.
     *
     * @param email the email
     * @return the email
     */
    public Email sendEmail(Email email) {

        log.info("Sending email...");

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(email.getEmailFrom());
            message.setTo(email.getEmailTo());
            message.setSubject(email.getSubject());
            message.setText(email.getBody());

            mailSender.send(message);

            email.setStatusEmail(StatusEmail.SENT);

        } catch (MailException e) {
            email.setStatusEmail(StatusEmail.ERROR);
            log.error("Error trying to send email...");
            e.printStackTrace();
        } finally {
            // TODO To implement attempts in order to send again
            return emailRepository.save(email);
        }

    }

}
