package com.institutohidrografico.shopping.persistence.payload.request;

import com.institutohidrografico.shopping.exception.annotation.*;
import com.institutohidrografico.shopping.persistence.model.Role;
import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.*;
import java.util.Collection;
import java.util.UUID;

@Getter @Setter @UniqueUsername
@UniqueEmail
public class DTORequestUser {

    private UUID id;
    @NotNull(message = "{user.name.not.null}") @NotBlank(message = "{user.name.not.blank}") @HasLength
    private String username;
    @NotBlank(message = "{user.email.not.blank}") @Size(max = 50) @Email
    private String email;
    @NotNull(message = "{user.password.not.null}") @NotBlank(message = "{user.password.not.blank}")
    @HasDigit
    @HasLetter
    @HasUpperCase
    @HasLowerCase
    @HasLength
    private String password;
    @NotNull(message = "{user.active.not.null}")
    private boolean active;
    private Collection<Role> role;
}