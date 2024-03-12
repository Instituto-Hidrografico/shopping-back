package com.institutohidrografico.shopping.persistence.repository;

import com.institutohidrografico.shopping.persistence.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RepositoryUser extends JpaRepository<User, UUID> {

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    Optional<User> findByUsername(String name);
    boolean existsByEmailIgnoreCase(String email);
    boolean existsByEmailIgnoreCaseAndIdNot(String email, UUID id);
    boolean existsByUsernameIgnoreCase(String value);
    boolean existsByUsernameIgnoreCaseAndIdNot(String username, UUID id);
    List<User> findByUsernameContainingIgnoreCaseOrderByUsernameAsc(String value);
    Page<User> findByIdOrderByIdAsc(Pageable pageable, UUID id);
    Page<User> findByUsernameContainingIgnoreCaseOrderByUsernameAsc(Pageable pageable, String username);
    Page<User> findByEmailContainingIgnoreCaseOrderByEmailAsc(Pageable pageable, String username);
}