package com.institutohidrografico.shopping.persistence.payload.response;

import com.institutohidrografico.shopping.persistence.model.Country;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public class DTOResponseState {

    private long id;
    private String name;
    private Country country;
}