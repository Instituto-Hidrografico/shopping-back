package com.institutohidrografico.shopping.service;

import com.institutohidrografico.shopping.persistence.MapStruct;
import com.institutohidrografico.shopping.persistence.model.FoodCategory;
import com.institutohidrografico.shopping.persistence.payload.request.DTORequestFoodCategory;
import com.institutohidrografico.shopping.persistence.payload.response.DTOResponseFoodCategory;
import com.institutohidrografico.shopping.persistence.repository.RepositoryFoodCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.util.UUID;

import static org.springframework.data.domain.ExampleMatcher.matching;

@Service
@RequiredArgsConstructor
public class ServiceFoodCategory implements ServiceInterface<DTOResponseFoodCategory, DTORequestFoodCategory> {

    private final RepositoryFoodCategory repositoryFoodCategory;

    @Override
    public DTOResponseFoodCategory create(DTORequestFoodCategory created) {
        return MapStruct.MAPPER.toDTO(repositoryFoodCategory.save(MapStruct.MAPPER.toObject(created)));
    }

    @Override
    public Page<DTOResponseFoodCategory> retrieve(Pageable pageable, String key, String value) {
        FoodCategory object = new FoodCategory();
        ExampleMatcher exampleMatcher = matching().withIgnoreNullValues().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        try {
            Method setMethod = object.getClass().getDeclaredMethod("set" + StringUtils.capitalize(pageable.getSort().stream().findFirst().get().getProperty()), String.class);
            setMethod.invoke(object, value);
            Example<FoodCategory> example = Example.of(object, exampleMatcher);
            return repositoryFoodCategory.findAll(example, pageable).map(MapStruct.MAPPER::toDTO);
        } catch (Exception e){
            return null;
        }
    }

    @Override
    public DTOResponseFoodCategory update(UUID id, DTORequestFoodCategory updated) {
        return MapStruct.MAPPER.toDTO(repositoryFoodCategory.save(MapStruct.MAPPER.toObject(updated)));
    }

    @Override
    public DTOResponseFoodCategory delete(UUID id) {
        DTOResponseFoodCategory dtoResponseFoodCategory = MapStruct.MAPPER.toDTO(repositoryFoodCategory.findById(id).orElse(null));
        repositoryFoodCategory.deleteById(id);
        return dtoResponseFoodCategory;
    }

    @Override
    public void delete() {
        repositoryFoodCategory.deleteAll();
    }

    public boolean existsByName(String value) {
        return repositoryFoodCategory.existsByNameIgnoreCase(value);
    }

    public boolean existsByNameAndIdNot(String value, UUID id) {
        return repositoryFoodCategory.existsByNameIgnoreCaseAndIdNot(value, id);
    }
}