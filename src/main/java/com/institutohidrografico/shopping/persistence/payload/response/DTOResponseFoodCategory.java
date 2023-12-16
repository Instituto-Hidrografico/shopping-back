package com.institutohidrografico.shopping.persistence.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter @AllArgsConstructor
public class DTOResponseFoodCategory {

    private UUID id;
    private String name;
}