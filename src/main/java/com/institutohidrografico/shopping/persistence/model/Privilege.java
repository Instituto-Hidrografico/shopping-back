package com.institutohidrografico.shopping.persistence.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import java.util.Collection;

@Audited @Entity @Data @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode(callSuper = true)
public class Privilege extends GenericEntity {

    private String name;

    @ManyToMany(mappedBy = "privileges")
    private Collection<Role> roles;
}