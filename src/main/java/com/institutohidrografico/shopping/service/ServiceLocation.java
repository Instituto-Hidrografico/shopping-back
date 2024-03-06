package com.institutohidrografico.shopping.service;

import com.institutohidrografico.shopping.persistence.MapStruct;
import com.institutohidrografico.shopping.persistence.model.Location;
import com.institutohidrografico.shopping.persistence.payload.request.DTORequestLocation;
import com.institutohidrografico.shopping.persistence.payload.response.DTOResponseLocation;
import com.institutohidrografico.shopping.persistence.repository.RepositoryLocation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service @RequiredArgsConstructor
public class ServiceLocation implements ServiceInterface<DTOResponseLocation, DTORequestLocation> {

    private final RepositoryLocation repositoryLocation;

    public DTOResponseLocation create(DTORequestLocation created){
        return MapStruct.MAPPER.toDTO(repositoryLocation.save(MapStruct.MAPPER.toObject(created)));
    }
    public Page<DTOResponseLocation> retrieve(Pageable pageable, String key, String value){
        switch (key) {
            case "id": {
                return repositoryLocation.findByIdOrderByIdAsc(pageable, UUID.fromString(value)).map(MapStruct.MAPPER::toDTO);
            }
            default: {
                return repositoryLocation.findAll(pageable).map(MapStruct.MAPPER::toDTO);
            }
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