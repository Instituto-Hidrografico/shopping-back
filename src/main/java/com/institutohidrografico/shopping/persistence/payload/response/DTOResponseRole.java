package com.institutohidrografico.shopping.persistence.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter @AllArgsConstructor
public class DTOResponseRole {

    private UUID id;
    private String name;
//    private Set<Privilege> privileges = new HashSet<>();
}