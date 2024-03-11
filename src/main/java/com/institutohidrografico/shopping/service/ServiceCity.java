package com.institutohidrografico.shopping.service;

import com.institutohidrografico.shopping.persistence.MapStruct;
import com.institutohidrografico.shopping.persistence.model.City;
import com.institutohidrografico.shopping.persistence.payload.request.DTORequestCity;
import com.institutohidrografico.shopping.persistence.payload.response.DTOResponseCity;
import com.institutohidrografico.shopping.persistence.repository.RepositoryCity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.endsWith;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.startsWith;
import static org.springframework.data.domain.ExampleMatcher.matching;

@Service @RequiredArgsConstructor
public class ServiceCity {

    private final RepositoryCity repositoryCity;

    public DTOResponseCity create(DTORequestCity created){
        return MapStruct.MAPPER.toDTO(repositoryCity.save(MapStruct.MAPPER.toObject(created)));
    }
    public Page<DTOResponseCity> retrieve(Pageable pageable, String value){
        City object = new City();
        ExampleMatcher exampleMatcher = matching().withIgnoreNullValues().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        try {
            Method setMethod = object.getClass().getDeclaredMethod("set" + StringUtils.capitalize(pageable.getSort().stream().findFirst().get().getProperty()), String.class);
            setMethod.invoke(object, value);
            Example<City> example = Example.of(object, exampleMatcher);
            return repositoryCity.findAll(example, pageable).map(MapStruct.MAPPER::toDTO);
        } catch (Exception e){
            return null;
        }
    }
    public DTOResponseCity update(long id, DTORequestCity updated){
        return MapStruct.MAPPER.toDTO(repositoryCity.save(MapStruct.MAPPER.toObject(updated)));
    }
    public DTOResponseCity delete(long id){
        City object = repositoryCity.findById(id).orElse(null);
        repositoryCity.deleteById(id);
        return MapStruct.MAPPER.toDTO(object);
    }
    public void delete() {
        repositoryCity.deleteAll();
    }
    public boolean existsByName(String value) {
        return repositoryCity.existsByNameIgnoreCase(value);
    }
    public boolean existsByNameAndIdNot(String value, long id) {
        return repositoryCity.existsByNameIgnoreCaseAndIdNot(value, id);
    }
}