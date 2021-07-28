package com.lopes.emailms.model;

import com.lopes.emailms.enumerations.StatusEmail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.OffsetDateTime;

/**
 * The type Email.
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "email")
public class Email {

    /**
     * The Email id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long emailId;

    /**
     * The Owner ref.
     */
    private String ownerRef;

    /**
     * The Email from.
     */
    private String emailFrom;

    /**
     * The Email to.
     */
    private String emailTo;

    /**
     * The Subject.
     */
    private String subject;

    /**
     * The Body.
     */
    @Column(columnDefinition = "TEXT")
    private String body;

    /**
     * The Send date email.
     */
    private OffsetDateTime sendDateEmail;

    /**
     * The Status email.
     */
    private StatusEmail statusEmail;

}
