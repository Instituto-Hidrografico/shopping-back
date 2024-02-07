package com.institutohidrografico.shopping.persistence.payload.request;

import com.institutohidrografico.shopping.persistence.model.Country;
import lombok.Getter;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Getter
public class DTORequestState {

    private long id;
    @NotNull(message = "{name.not.null}") @NotBlank(message = "{name.not.blank}")
    private String name;
    private Country country;
}