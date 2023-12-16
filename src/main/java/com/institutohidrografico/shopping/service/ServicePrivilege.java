package com.institutohidrografico.shopping.service;

import com.institutohidrografico.shopping.persistence.MapStruct;
import com.institutohidrografico.shopping.persistence.payload.request.DTORequestPrivilege;
import com.institutohidrografico.shopping.persistence.payload.response.DTOResponsePrivilege;
import com.institutohidrografico.shopping.persistence.repository.RepositoryPrivilege;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service @RequiredArgsConstructor
public class ServicePrivilege implements ServiceInterface<DTOResponsePrivilege, DTORequestPrivilege> {

    private final RepositoryPrivilege repositoryPrivilege;

    @Override
    public DTOResponsePrivilege create(DTORequestPrivilege created){
        return MapStruct.MAPPER.toDTO(repositoryPrivilege.save(MapStruct.MAPPER.toObject(created)));
    }
    @Override
    public Page<DTOResponsePrivilege> retrieve(Pageable pageable, String key, String value){
        switch (key) {
            case "id": {
                return repositoryPrivilege.findByIdOrderByIdAsc(pageable, UUID.fromString(value)).map(MapStruct.MAPPER::toDTO);
            }
            case "name": {
                return repositoryPrivilege.findByNameContainingIgnoreCaseOrderByNameAsc(pageable, value).map(MapStruct.MAPPER::toDTO);
            }
            default: {
                return repositoryPrivilege.findAll(pageable).map(MapStruct.MAPPER::toDTO);
            }
        }
    }
    @Override
    public DTOResponsePrivilege update(UUID id, DTORequestPrivilege updated){
        return MapStruct.MAPPER.toDTO(repositoryPrivilege.save(MapStruct.MAPPER.toObject(updated)));
    }
    @Override
    public DTOResponsePrivilege delete(UUID id){
        DTOResponsePrivilege dtoResponsePrivilege = MapStruct.MAPPER.toDTO(repositoryPrivilege.findById(id).orElse(null));
        repositoryPrivilege.deleteById(id);
        return dtoResponsePrivilege;
    }
    @Override
    public void delete() {
        repositoryPrivilege.deleteAll();
    }

    public boolean existsByName(String value) {
        return repositoryPrivilege.existsByNameIgnoreCase(value);
    }
    public boolean existsByNameAndIdNot(String value, UUID id) {
        return repositoryPrivilege.existsByNameIgnoreCaseAndIdNot(value, id);
    }
}