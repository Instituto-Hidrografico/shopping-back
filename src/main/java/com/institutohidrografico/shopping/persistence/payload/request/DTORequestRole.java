package com.institutohidrografico.shopping.persistence.payload.request;

import com.institutohidrografico.shopping.exception.annotation.UniqueNameRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.UUID;

@Getter @UniqueNameRole
public class DTORequestRole {

    private UUID id;
    @NotNull(message = "{role.name.not.null}") @NotBlank(message = "{role.name.not.blank}")
    private String name;
//    private Set<Privilege> privileges = new HashSet<>();
}