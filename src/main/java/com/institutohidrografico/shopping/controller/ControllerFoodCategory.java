package com.institutohidrografico.shopping.controller;

import com.institutohidrografico.shopping.persistence.payload.request.DTORequestFoodCategory;
import com.institutohidrografico.shopping.persistence.payload.response.DTOResponseFoodCategory;
import com.institutohidrografico.shopping.service.ServiceFoodCategory;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController @RequestMapping("/food_category") @RequiredArgsConstructor
public class ControllerFoodCategory implements ControllerInterface<DTOResponseFoodCategory, DTORequestFoodCategory> {

    private final ServiceFoodCategory serviceFoodCategory;

    @PostMapping("") @Override @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseFoodCategory> create(@RequestBody @Valid DTORequestFoodCategory created){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/food_category").toUriString());
        return ResponseEntity.created(uri).body(serviceFoodCategory.create(created));
    }
    @GetMapping("") @Override
    public ResponseEntity<Page<DTOResponseFoodCategory>> retrieve(@RequestParam(name = "key", defaultValue = "", required = false) String key, @RequestParam(name="value", defaultValue = "", required = false) String value, Pageable pageable){
        return ResponseEntity.ok().body(serviceFoodCategory.retrieve(pageable, key, value));
    }
    @PutMapping("") @Override @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseFoodCategory> update(@RequestBody @Valid DTORequestFoodCategory updated){
        return ResponseEntity.accepted().body(serviceFoodCategory.update(updated.getId(), updated));
    }
    @DeleteMapping("/{id}") @Override @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseFoodCategory> delete(@PathVariable("id") UUID id){
        return ResponseEntity.accepted().body(serviceFoodCategory.delete(id));
    }
    @DeleteMapping("") @Override @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<HttpStatus> delete(){
        try {
            serviceFoodCategory.delete();
            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        }
    }
}