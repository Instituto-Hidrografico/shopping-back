package com.institutohidrografico.shopping.persistence.repository;

import com.institutohidrografico.shopping.persistence.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RepositoryFood extends JpaRepository<Food, UUID>, RepositoryInterface<Food> {

    boolean existsByIbgeCodeIgnoreCase(String ibgeCode);
    boolean existsByIbgeCodeIgnoreCaseAndIdNot (String name, UUID id);
}