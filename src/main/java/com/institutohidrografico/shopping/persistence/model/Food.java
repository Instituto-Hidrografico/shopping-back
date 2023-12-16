package com.institutohidrografico.shopping.persistence.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import java.math.BigDecimal;

@Audited @Entity @Data @AllArgsConstructor @NoArgsConstructor @Table(uniqueConstraints = @UniqueConstraint(columnNames = {"ibgeCode", "name"})) @EqualsAndHashCode(callSuper = false)
public class Food extends GenericEntity {

    private String ibgeCode;
    private String name;
//    @OneToOne
    private String preparation;
    private String foodCategory;
//    energy, macronutrients and fiber
    @Column(nullable = true)
    private BigDecimal energy;
    @Column(nullable = true)
    private BigDecimal protein;
    @Column(nullable = true)
    private BigDecimal totalLipids;
    @Column(nullable = true)
    private BigDecimal carbohydrate;
    @Column(nullable = true)
    private BigDecimal fiber;
//    fats and sugar
    @Column(nullable = true)
    private BigDecimal cholesterol;
    @Column(nullable = true)
    private BigDecimal saturated;
    @Column(nullable = true)
    private BigDecimal monounsaturated;
    @Column(nullable = true)
    private BigDecimal polyunsaturated;
    @Column(nullable = true)
    private BigDecimal linoleic;
    @Column(nullable = true)
    private BigDecimal linolenic;
    @Column(nullable = true)
    private BigDecimal trans;
    @Column(nullable = true)
    private BigDecimal totalSugar;
    @Column(nullable = true)
    private BigDecimal addedSugar;
//    minearals
    @Column(nullable = true)
    private BigDecimal calcium;
    @Column(nullable = true)
    private BigDecimal magnesium;
    @Column(nullable = true)
    private BigDecimal manganese;
    @Column(nullable = true)
    private BigDecimal phosphorus;
    @Column(nullable = true)
    private BigDecimal iron;
    @Column(nullable = true)
    private BigDecimal sodium;
    @Column(nullable = true)
    private BigDecimal addedSodium;
    @Column(nullable = true)
    private BigDecimal potassium;
    @Column(nullable = true)
    private BigDecimal copper;
    @Column(nullable = true)
    private BigDecimal zinc;
    @Column(nullable = true)
    private BigDecimal selenium;
//    vitaminas
    @Column(nullable = true)
    private BigDecimal retinol;
    @Column(nullable = true)
    private BigDecimal vitaminaA;
    @Column(nullable = true)
    private BigDecimal tiamina;
    @Column(nullable = true)
    private BigDecimal riboflavina;
    @Column(nullable = true)
    private BigDecimal niacina;
    @Column(nullable = true)
    private BigDecimal niacinaNE;
    @Column(nullable = true)
    private BigDecimal piridoxina;
    @Column(nullable = true)
    private BigDecimal cobalamina;
    @Column(nullable = true)
    private BigDecimal folato;
    @Column(nullable = true)
    private BigDecimal vitaminaD;
    @Column(nullable = true)
    private BigDecimal vitaminaE;
    @Column(nullable = true)
    private BigDecimal vitaminaC;
}