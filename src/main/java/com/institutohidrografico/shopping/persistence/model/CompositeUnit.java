package com.institutohidrografico.shopping.persistence.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import java.util.Date;

@IdClass(CompositePK.class)
@Audited @Entity @Data @AllArgsConstructor @NoArgsConstructor
public class CompositeUnit {
    @Id
    private String name;
    @Id
    private int number;
    private String value;
    @Temporal(TemporalType.DATE)
    private Date date;
}
