package com.institutohidrografico.shopping.persistence.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

@Audited @Entity @Data @AllArgsConstructor @NoArgsConstructor
public class RecipeCategory extends GenericEntity {
    private String name;
}
//Bolos, Lanches e salgados, Pratos principais, Acompanhamentos, Massas, Arroz e risotos, Saladas e entradas, Sopas e caldos, Doces e sobremesas
