package com.institutohidrografico.shopping.persistence.payload.response;

import com.institutohidrografico.shopping.persistence.model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Collection;
import java.util.UUID;

@Getter @AllArgsConstructor
public class DTOResponseUser {

    private UUID id;
    private String username;
    private String email;
    private String password;
    private Boolean active;
    private Collection<Role> role;
}