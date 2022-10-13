package com.index325.msuser.dtos;

import com.index325.msuser.entities.User;

import javax.validation.constraints.NotBlank;
import java.util.UUID;


public class UserDTO {
    UUID id;

    @NotBlank
    String name;

    @NotBlank
    String email;

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
    }

    public UserDTO() {
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
}
