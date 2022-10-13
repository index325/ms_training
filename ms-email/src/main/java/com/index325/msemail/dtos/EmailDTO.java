package com.index325.msemail.dtos;

import com.index325.msemail.entities.Email;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class EmailDTO {
    UUID id;

    @NotBlank
    String name;

    @NotBlank
    String email;

    String isSent;

    public EmailDTO(Email email) {
        this.name = email.getName();
        this.email = email.getEmail();
    }

    public EmailDTO() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIsSent() {
        return isSent;
    }

    public void setIsSent(String isSent) {
        this.isSent = isSent;
    }
}
