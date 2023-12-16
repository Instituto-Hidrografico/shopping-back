package com.institutohidrografico.shopping.persistence.repository;

import com.institutohidrografico.shopping.persistence.model.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RepositoryPrivilege extends JpaRepository<Privilege, UUID>, RepositoryInterface<Privilege> {

}