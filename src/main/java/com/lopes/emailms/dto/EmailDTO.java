package com.lopes.emailms.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * The type Email dto.
 */
@Data
public class EmailDTO {

    /**
     * The Owner ref.
     */
    @NotBlank
    private String ownerRef;

    /**
     * The Email from.
     */
    @NotBlank
    @Email
    private String emailFrom;

    /**
     * The Email to.
     */
    @NotBlank
    @Email
    private String emailTo;

    /**
     * The Subject.
     */
    @NotBlank
    private String subject;

    /**
     * The Body.
     */
    @NotBlank
    private String body;

}
