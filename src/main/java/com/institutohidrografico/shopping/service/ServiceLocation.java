package com.institutohidrografico.shopping.service;

import com.institutohidrografico.shopping.persistence.MapStruct;
import com.institutohidrografico.shopping.persistence.model.Location;
import com.institutohidrografico.shopping.persistence.payload.request.DTORequestLocation;
import com.institutohidrografico.shopping.persistence.payload.response.DTOResponseLocation;
import com.institutohidrografico.shopping.persistence.repository.RepositoryLocation;
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

@Service @RequiredArgsConstructor
public class ServiceLocation implements ServiceInterface<DTOResponseLocation, DTORequestLocation> {

    private final RepositoryLocation repositoryLocation;

    public DTOResponseLocation create(DTORequestLocation created){
        return MapStruct.MAPPER.toDTO(repositoryLocation.save(MapStruct.MAPPER.toObject(created)));
    }
    public Page<DTOResponseLocation> retrieve(Pageable pageable, String key, String value){
        Location object = new Location();
        ExampleMatcher exampleMatcher = matching().withIgnoreNullValues().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        try {
            Method setMethod = object.getClass().getDeclaredMethod("set" + StringUtils.capitalize(pageable.getSort().stream().findFirst().get().getProperty()), String.class);
            setMethod.invoke(object, value);
            Example<Location> example = Example.of(object, exampleMatcher);
            return repositoryLocation.findAll(example, pageable).map(MapStruct.MAPPER::toDTO);
        } catch (Exception e){
            return repositoryLocation.findAll(pageable).map(MapStruct.MAPPER::toDTO);
        }
    }
    public DTOResponseLocation update(UUID id, DTORequestLocation updated){
        return MapStruct.MAPPER.toDTO(repositoryLocation.save(MapStruct.MAPPER.toObject(updated)));
    }
    public DTOResponseLocation delete(UUID id){
        Location object = repositoryLocation.findById(id).orElse(null);
        repositoryLocation.deleteById(id);
        return MapStruct.MAPPER.toDTO(object);
    }
    public void delete() {
        repositoryLocation.deleteAll();
    }
}