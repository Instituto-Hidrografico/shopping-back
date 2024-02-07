package com.institutohidrografico.shopping.persistence;

import com.institutohidrografico.shopping.persistence.model.*;
import com.institutohidrografico.shopping.persistence.payload.request.*;
import com.institutohidrografico.shopping.persistence.payload.response.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel="spring")
public interface MapStruct {

    MapStruct MAPPER = Mappers.getMapper(MapStruct.class);
    DTOResponseCountry toDTO(Country country);
    DTOResponseFood toDTO(Food food);
    DTOResponseFoodCategory toDTO(FoodCategory foodCategory);
    DTOResponseUser toDTO(User user);
    DTOResponseRole toDTO(Role role);
    DTOResponsePrivilege toDTO(Privilege privilege);
    DTOResponseCompositeUnit toDTO(CompositeUnit compositeUnit);
    DTOResponseState toDTO(State state);
    DTOResponseCity toDTO(City city);

    Country toObject(DTORequestCountry dtoRequestCountry);
    Food toObject(DTORequestFood dtoRequestFood);
    FoodCategory toObject(DTORequestFoodCategory dtoRequestFoodCategory);
    User toObject(DTORequestUser dtoRequestUser);
    Role toObject(DTORequestRole dtoRequestRole);
    Privilege toObject(DTORequestPrivilege dtoRequestPrivilege);
    CompositeUnit toObject(DTORequestCompositeUnit dtoRequestCompositeUnit);
    State toObject(DTORequestState dtoRequestState);
    City toObject(DTORequestCity dtoRequestCity);
}