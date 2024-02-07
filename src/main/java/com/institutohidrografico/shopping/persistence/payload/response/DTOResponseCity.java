package com.institutohidrografico.shopping.persistence.payload.response;

import com.institutohidrografico.shopping.persistence.model.State;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public class DTOResponseCity {

    private long id;
    private String name;
    private State state;
}