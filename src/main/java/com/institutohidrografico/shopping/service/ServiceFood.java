package com.institutohidrografico.shopping.service;

import com.institutohidrografico.shopping.persistence.MapStruct;
import com.institutohidrografico.shopping.persistence.payload.request.DTORequestFood;
import com.institutohidrografico.shopping.persistence.payload.response.DTOResponseFood;
import com.institutohidrografico.shopping.persistence.repository.RepositoryFood;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service @RequiredArgsConstructor
public class ServiceFood implements ServiceInterface<DTOResponseFood, DTORequestFood> {

    private final RepositoryFood repositoryFood;
//    private final RepositoryFoodPage repositoryFoodPage;

    @Override
    public DTOResponseFood create(DTORequestFood created){
        return MapStruct.MAPPER.toDTO(repositoryFood.save(MapStruct.MAPPER.toObject(created)));
    }
    @Override
    public Page<DTOResponseFood> retrieve(Pageable pageable, String key, String value) {
        switch (key) {
            case "id": {
                return repositoryFood.findByIdOrderByIdAsc(pageable, UUID.fromString(value)).map(MapStruct.MAPPER::toDTO);
            }
            case "name": {
                return repositoryFood.findByNameContainingIgnoreCaseOrderByNameAsc(pageable, value).map(MapStruct.MAPPER::toDTO);
            }
            default: {
                return repositoryFood.findAll(pageable).map(MapStruct.MAPPER::toDTO);
            }
        }
    }
    @Override
    public DTOResponseFood update(UUID id, DTORequestFood updated){
        return MapStruct.MAPPER.toDTO(repositoryFood.save(MapStruct.MAPPER.toObject(updated)));
    }
    @Override
    public DTOResponseFood delete(UUID id){
        DTOResponseFood dtoResponseFood = MapStruct.MAPPER.toDTO(repositoryFood.findById(id).orElse(null));
        repositoryFood.deleteById(id);
        return dtoResponseFood;
    }
    @Override
    public void delete() {
        repositoryFood.deleteAll();
    }

    public boolean existsByName(String value) {
        return repositoryFood.existsByNameIgnoreCase(value);
    }
    public boolean existsByNameAndIdNot(String value, UUID id) {
        return repositoryFood.existsByNameIgnoreCaseAndIdNot(value, id);
    }
    public boolean existsByIbgeCode(String value) {
        return repositoryFood.existsByIbgeCodeIgnoreCase(value);
    }
    public boolean existsByIbgeCodeAndIdNot(String value, UUID id) {
        return repositoryFood.existsByIbgeCodeIgnoreCaseAndIdNot(value, id);
    }
}