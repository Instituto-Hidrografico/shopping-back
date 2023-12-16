package com.institutohidrografico.shopping.persistence.payload.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.Date;

@Getter
public class DTORequestCompositeUnit {

    @NotNull(message = "{unit.name.not.null}") @NotBlank(message = "{unit.name.not.blank}")
    private String name;
    @NotNull(message = "{unit.number.not.null}") @Min(1)
    private int number;
    private String value;
    @NotNull(message = "{unit.date.not.null}")
    private Date date;
}