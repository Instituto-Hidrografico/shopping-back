package com.institutohidrografico.shopping.service;

import com.institutohidrografico.shopping.persistence.MapStruct;
import com.institutohidrografico.shopping.persistence.model.City;
import com.institutohidrografico.shopping.persistence.payload.request.DTORequestCity;
import com.institutohidrografico.shopping.persistence.payload.response.DTOResponseCity;
import com.institutohidrografico.shopping.persistence.repository.RepositoryCity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

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
        ExampleMatcher exampleMatcher = matching()
                .withMatcher("a", startsWith().ignoreCase())
//                .withMatcher("a", endsWith().ignoreCase())
//                .withIncludeNullValues()
//                .withIgnorePaths("role")
                .withStringMatcher(ExampleMatcher.StringMatcher.ENDING);
        Example<City> example = Example.of(new City(), exampleMatcher);
        System.out.println(repositoryCity.findAll(example));

        String value2 = (pageable.getSort().stream().findFirst().get() == null ? "id" : pageable.getSort().stream().findFirst().get().getProperty());
        switch (value2) {
            case "id" -> {
                return repositoryCity.findByIdOrderByIdAsc(pageable, Long.parseLong(value)).map(MapStruct.MAPPER::toDTO);
            }
            case "name" -> {
                return repositoryCity.findByNameContainingIgnoreCaseOrderByNameAsc(pageable, value).map(MapStruct.MAPPER::toDTO);
            }
            default -> {
//                return repositoryCity.findAll(pageable).map(MapStruct.MAPPER::toDTO);
                return repositoryCity.findAll(PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), pageable.getSort())).map(MapStruct.MAPPER::toDTO);
            }
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