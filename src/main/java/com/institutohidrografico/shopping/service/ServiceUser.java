package com.institutohidrografico.shopping.service;

import com.institutohidrografico.shopping.persistence.MapStruct;
import com.institutohidrografico.shopping.persistence.model.User;
import com.institutohidrografico.shopping.persistence.payload.request.DTORequestUser;
import com.institutohidrografico.shopping.persistence.payload.response.DTOResponseUser;
import com.institutohidrografico.shopping.persistence.repository.RepositoryRole;
import com.institutohidrografico.shopping.persistence.repository.RepositoryUser;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Objects;
import java.util.UUID;

@Service @RequiredArgsConstructor
public class ServiceUser implements ServiceInterface<DTOResponseUser, DTORequestUser> {

    private final RepositoryUser repositoryUser;
    private final RepositoryRole repositoryRole;
    private final PasswordEncoder passwordEncoder;

    @Override
    public DTOResponseUser create(DTORequestUser created){
        User user = MapStruct.MAPPER.toObject(created);
        user.setPassword(passwordEncoder.encode(created.getPassword()));
        user.setRole(Collections.singletonList(repositoryRole.findByName("ROLE_USER")));
        return MapStruct.MAPPER.toDTO(repositoryUser.save(user));
    }
    @Override
    public Page<DTOResponseUser> retrieve(Pageable pageable, String key, String value) {
        switch (key) {
            case "id": {
                return repositoryUser.findByIdOrderByIdAsc(pageable, UUID.fromString(value)).map(MapStruct.MAPPER::toDTO);
            }
            case "username": {
                return repositoryUser.findByUsernameContainingIgnoreCaseOrderByUsernameAsc(pageable, value).map(MapStruct.MAPPER::toDTO);
            }
            case "email": {
                return repositoryUser.findByEmailContainingIgnoreCaseOrderByEmailAsc(pageable, value).map(MapStruct.MAPPER::toDTO);
            }
            default: {
                return repositoryUser.findAll(pageable).map(MapStruct.MAPPER::toDTO);
            }
        }
    }
    @Override
    public DTOResponseUser update(UUID id, DTORequestUser updated){
        User user = MapStruct.MAPPER.toObject(updated);
        user.setPassword(Objects.requireNonNull(repositoryUser.findById(updated.getId()).orElse(null)).getPassword());
        return MapStruct.MAPPER.toDTO(repositoryUser.save(user));
    }
    @Override
    public DTOResponseUser delete(UUID id){
        DTOResponseUser dtoResponseUser = MapStruct.MAPPER.toDTO(repositoryUser.findById(id).orElse(null));
        repositoryUser.deleteById(id);
        return dtoResponseUser;
    }
    @Override
    public void delete() {
        repositoryUser.deleteAll();
    }

    public boolean existsByName(String value) {
        return repositoryUser.existsByUsernameIgnoreCase(value);
    }
    public boolean existsByNameAndIdNot(String value, UUID id) {
        return repositoryUser.existsByUsernameIgnoreCaseAndIdNot(value, id);
    }
    public boolean existsByEmail(String value) {
        return repositoryUser.existsByEmailIgnoreCase(value);
    }
    public boolean existsByEmailAndIdNot(String value, UUID id) {
        return repositoryUser.existsByEmailIgnoreCaseAndIdNot(value, id);
    }

    public DTOResponseUser changePassword(DTORequestUser updated){
        User user = repositoryUser.findById(updated.getId()).orElse(null);
        Objects.requireNonNull(user).setPassword(passwordEncoder.encode(updated.getPassword()));
        return MapStruct.MAPPER.toDTO(repositoryUser.save(user));
    }
}