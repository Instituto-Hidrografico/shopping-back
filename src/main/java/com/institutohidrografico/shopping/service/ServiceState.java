package com.institutohidrografico.shopping.service;

import com.institutohidrografico.shopping.persistence.MapStruct;
import com.institutohidrografico.shopping.persistence.model.State;
import com.institutohidrografico.shopping.persistence.payload.request.DTORequestState;
import com.institutohidrografico.shopping.persistence.payload.response.DTOResponseState;
import com.institutohidrografico.shopping.persistence.repository.RepositoryState;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;

import static org.springframework.data.domain.ExampleMatcher.matching;

@Service @RequiredArgsConstructor
public class ServiceState {

    private final RepositoryState repositoryState;

    public DTOResponseState create(DTORequestState created){
        return MapStruct.MAPPER.toDTO(repositoryState.save(MapStruct.MAPPER.toObject(created)));
    }
    public Page<DTOResponseState> retrieve(Pageable pageable, String key, String value){
        State object = new State();
        ExampleMatcher exampleMatcher = matching().withIgnoreNullValues().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        try {
            Method setMethod = object.getClass().getDeclaredMethod("set" + StringUtils.capitalize(pageable.getSort().stream().findFirst().get().getProperty()), String.class);
            setMethod.invoke(object, value);
            Example<State> example = Example.of(object, exampleMatcher);
            return repositoryState.findAll(example, pageable).map(MapStruct.MAPPER::toDTO);
        } catch (Exception e){
            return null;
        }
    }
    public DTOResponseState update(long id, DTORequestState updated){
        return MapStruct.MAPPER.toDTO(repositoryState.save(MapStruct.MAPPER.toObject(updated)));
    }
    public DTOResponseState delete(long id){
        State object = repositoryState.findById(id).orElse(null);
        repositoryState.deleteById(id);
        return MapStruct.MAPPER.toDTO(object);
    }
    public void delete() {
        repositoryState.deleteAll();
    }
    public boolean existsByName(String value) {
        return repositoryState.existsByNameIgnoreCase(value);
    }
    public boolean existsByNameAndIdNot(String value, long id) {
        return repositoryState.existsByNameIgnoreCaseAndIdNot(value, id);
    }
}