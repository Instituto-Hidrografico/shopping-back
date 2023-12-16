package com.institutohidrografico.shopping.service;

import com.institutohidrografico.shopping.persistence.MapStruct;
import com.institutohidrografico.shopping.persistence.payload.request.DTORequestFoodCategory;
import com.institutohidrografico.shopping.persistence.payload.response.DTOResponseFoodCategory;
import com.institutohidrografico.shopping.persistence.repository.RepositoryFoodCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

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
        switch (key) {
            case "id": {
                return repositoryFoodCategory.findByIdOrderByIdAsc(pageable, UUID.fromString(value)).map(MapStruct.MAPPER::toDTO);
            }
            case "name": {
                return repositoryFoodCategory.findByNameContainingIgnoreCaseOrderByNameAsc(pageable, value).map(MapStruct.MAPPER::toDTO);
            }
            default: {
                return repositoryFoodCategory.findAll(pageable).map(MapStruct.MAPPER::toDTO);
            }
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