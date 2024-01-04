package com.institutohidrografico.shopping.persistence.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

@Audited @Entity @Data @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode(callSuper = true)
public class RecipeCategory extends GenericEntity {
    private String name;
}
//Bolos, Lanches e salgados, Pratos principais, Acompanhamentos, Massas, Arroz e risotos, Saladas e entradas, Sopas e caldos, Doces e sobremesas
