package com.institutohidrografico.shopping.service;

import com.institutohidrografico.shopping.persistence.MapStruct;
import com.institutohidrografico.shopping.persistence.model.CompositePK;
import com.institutohidrografico.shopping.persistence.model.CompositeUnit;
import com.institutohidrografico.shopping.persistence.payload.request.DTORequestCompositeUnit;
import com.institutohidrografico.shopping.persistence.payload.response.DTOResponseCompositeUnit;
import com.institutohidrografico.shopping.persistence.repository.RepositoryCompositeUnit;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;

import static org.springframework.data.domain.ExampleMatcher.matching;

@Service @RequiredArgsConstructor
public class ServiceCompositeUnit {

    private final RepositoryCompositeUnit repositoryCompositeUnit;

    public DTOResponseCompositeUnit create(DTORequestCompositeUnit created){
        return MapStruct.MAPPER.toDTO(repositoryCompositeUnit.save(MapStruct.MAPPER.toObject(created)));
    }
    public Page<DTOResponseCompositeUnit> retrieveComposite(Pageable pageable, String key, String value, String name, int number) {
        CompositeUnit object = new CompositeUnit();
        ExampleMatcher exampleMatcher = matching().withIgnoreNullValues().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        try {
            Method setMethod = object.getClass().getDeclaredMethod("set" + StringUtils.capitalize(pageable.getSort().stream().findFirst().get().getProperty()), String.class);
            setMethod.invoke(object, value);
            Example<CompositeUnit> example = Example.of(object, exampleMatcher);
            return repositoryCompositeUnit.findAll(example, pageable).map(MapStruct.MAPPER::toDTO);
        } catch (Exception e){
            return repositoryCompositeUnit.findAll(PageRequest.of(0, 3, Sort.by("id"))).map(MapStruct.MAPPER::toDTO);
        }
    }
    public Page<DTOResponseCompositeUnit> retrieve(Pageable pageable, String key, String value) {
        switch (key) {
            case "name": {
                return repositoryCompositeUnit.findByNameContainingIgnoreCaseOrderByNameAsc(pageable, value).map(MapStruct.MAPPER::toDTO);
            }
            case "value": {
                return repositoryCompositeUnit.findByValueContainingIgnoreCaseOrderByValueAsc(pageable, value).map(MapStruct.MAPPER::toDTO);
            }
            default: {
                return repositoryCompositeUnit.findAll(pageable).map(MapStruct.MAPPER::toDTO);
            }
        }
    }
    public DTOResponseCompositeUnit update(CompositePK id, DTORequestCompositeUnit updated){
        return MapStruct.MAPPER.toDTO(repositoryCompositeUnit.save(MapStruct.MAPPER.toObject(updated)));
    }
    public DTOResponseCompositeUnit delete(CompositePK id){
        DTOResponseCompositeUnit dtoResponseCompositeUnit = MapStruct.MAPPER.toDTO(repositoryCompositeUnit.findById(id).orElse(null));
        repositoryCompositeUnit.deleteById(id);
        return dtoResponseCompositeUnit;
    }
    public void delete() {
        repositoryCompositeUnit.deleteAll();
    }
}