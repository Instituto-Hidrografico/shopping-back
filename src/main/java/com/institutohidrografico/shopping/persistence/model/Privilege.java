package com.institutohidrografico.shopping.persistence.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

@Audited @Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Privilege extends GenericEntity {

    private String name;

//    @ManyToMany(mappedBy = "privileges")
//    private Set<Role> roles = new HashSet<>();
}