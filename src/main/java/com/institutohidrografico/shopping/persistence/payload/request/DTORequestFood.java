package com.institutohidrografico.shopping.persistence.payload.request;

import com.institutohidrografico.shopping.exception.annotation.UniqueIbgeCode;
import com.institutohidrografico.shopping.exception.annotation.UniqueNameFood;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter @UniqueNameFood @UniqueIbgeCode
public class DTORequestFood {

    private UUID id;
    @NotNull(message = "{ibge.not.null}") @NotBlank(message = "{ibge.not.blank}")
    private String ibgeCode;
    @NotNull(message = "{food.name.not.null}") @NotBlank(message = "{food.name.not.blank}")
    private String name;
    private String preparation;
    private BigDecimal energy;
    private BigDecimal protein;
    private BigDecimal totalLipids;
    private BigDecimal carbohydrate;
    private BigDecimal fiber;
    private BigDecimal cholesterol;
    private BigDecimal saturated;
    private BigDecimal monounsaturated;
    private BigDecimal polyunsaturated;
    private BigDecimal linoleic;
    private BigDecimal linolenic;
    private BigDecimal trans;
    private BigDecimal totalSugar;
    private BigDecimal addedSugar;
    private BigDecimal calcium;
    private BigDecimal magnesium;
    private BigDecimal manganese;
    private BigDecimal phosphorus;
    private BigDecimal iron;
    private BigDecimal sodium;
    private BigDecimal addedSodium;
    private BigDecimal potassium;
    private BigDecimal copper;
    private BigDecimal zinc;
    private BigDecimal selenium;
    private BigDecimal retinol;
    private BigDecimal vitaminaA;
    private BigDecimal tiamina;
    private BigDecimal riboflavina;
    private BigDecimal niacina;
    private BigDecimal niacinaNE;
    private BigDecimal piridoxina;
    private BigDecimal cobalamina;
    private BigDecimal folato;
    private BigDecimal vitaminaD;
    private BigDecimal vitaminaE;
    private BigDecimal vitaminaC;
}