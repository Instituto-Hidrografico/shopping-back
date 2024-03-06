package com.institutohidrografico.shopping.persistence.repository;

import com.institutohidrografico.shopping.persistence.model.Location;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RepositoryLocation extends JpaRepository<Location, UUID> {
    Page<Location> findByIdOrderByIdAsc(Pageable pageable, UUID id);
}