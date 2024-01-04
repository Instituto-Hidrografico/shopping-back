package com.institutohidrografico.shopping.persistence.payload.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class DTORequestAuth {

    @NotNull(message = "{auth.username.not.null}") @NotBlank(message = "{auth.username.not.blank}")
    private String username;
    @NotNull(message = "{auth.password.not.null}") @NotBlank(message = "{auth.password.not.blank}")
    private String password;
}