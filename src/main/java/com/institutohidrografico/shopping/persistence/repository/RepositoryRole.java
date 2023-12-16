package com.institutohidrografico.shopping.persistence.repository;

import com.institutohidrografico.shopping.persistence.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RepositoryRole extends JpaRepository<Role, UUID>, RepositoryInterface<Role> {

}