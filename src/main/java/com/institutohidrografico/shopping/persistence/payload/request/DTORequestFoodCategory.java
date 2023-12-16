package com.institutohidrografico.shopping.persistence.payload.request;

import com.institutohidrografico.shopping.exception.annotation.UniqueNameFoodCategory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.UUID;

@Getter @UniqueNameFoodCategory
public class DTORequestFoodCategory {

    private UUID id;
    @NotNull(message = "{food.category.name.not.null}") @NotBlank(message = "{food.category.name.not.blank}")
    private String name;
}