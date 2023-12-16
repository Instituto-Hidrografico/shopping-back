package com.institutohidrografico.shopping.persistence.repository;

import com.institutohidrografico.shopping.persistence.model.FoodCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RepositoryFoodCategory extends JpaRepository<FoodCategory, UUID>, RepositoryInterface<FoodCategory> {

}