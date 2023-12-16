package com.institutohidrografico.shopping.controller;

import com.institutohidrografico.shopping.persistence.payload.request.DTORequestFood;
import com.institutohidrografico.shopping.persistence.payload.response.DTOResponseFood;
import com.institutohidrografico.shopping.service.ServiceFood;
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

@RestController @RequestMapping("/food") @RequiredArgsConstructor
public class ControllerFood implements ControllerInterface<DTOResponseFood, DTORequestFood> {

    private final ServiceFood serviceFood;

    @PostMapping("") @Override @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseFood> create(@RequestBody @Valid DTORequestFood created){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/food").toUriString());
        return ResponseEntity.created(uri).body(serviceFood.create(created));
    }
    @GetMapping("") @Override
    public ResponseEntity<Page<DTOResponseFood>> retrieve(@RequestParam(name = "key", defaultValue = "", required = false) String key, @RequestParam(name="value", defaultValue = "", required = false) String value, Pageable pageable){
        return ResponseEntity.ok().body(serviceFood.retrieve(pageable, key, value));
    }
    @PutMapping("") @Override @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseFood> update(@RequestBody @Valid DTORequestFood updated){
        return ResponseEntity.accepted().body(serviceFood.update(updated.getId(), updated));
    }
    @DeleteMapping("/{id}") @Override @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseFood> delete(@PathVariable("id") UUID id){
        return ResponseEntity.accepted().body(serviceFood.delete(id));
    }
    @DeleteMapping("") @Override @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<HttpStatus> delete(){
        try {
            serviceFood.delete();
            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        }
    }
}