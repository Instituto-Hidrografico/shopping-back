package com.institutohidrografico.shopping.persistence.payload.request;

import com.institutohidrografico.shopping.exception.annotation.UniqueNamePrivilege;
import com.institutohidrografico.shopping.persistence.model.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter @UniqueNamePrivilege
public class DTORequestPrivilege {

    private UUID id;
    @NotNull(message = "{privilege.name.not.null}") @NotBlank(message = "{privilege.name.not.blank}")
    private String name;
    private Set<Role> roles = new HashSet<>();
}