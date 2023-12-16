package com.institutohidrografico.shopping.persistence.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter @AllArgsConstructor
public class DTOResponseFood {

    private UUID id;
    private String ibgeCode;
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