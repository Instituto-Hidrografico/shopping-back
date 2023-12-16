package com.institutohidrografico.shopping.persistence.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import java.util.Collection;

@Audited @Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Recipe extends GenericEntity {
    private Collection<String> ingredient;
    private Preparation preparation;
    private int portion;
}