package com.institutohidrografico.shopping.persistence.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter @AllArgsConstructor
public class DTOResponseCompositeUnit {

    private String name;
    private int number;
    private String value;
    private Date date;
}