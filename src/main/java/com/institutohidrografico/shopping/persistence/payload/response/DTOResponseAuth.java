package com.institutohidrografico.shopping.persistence.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter @AllArgsConstructor
public class DTOResponseAuth {

    private String accessToken;
    private String tokenType = "Bearer ";
    private List<String> roles;
}