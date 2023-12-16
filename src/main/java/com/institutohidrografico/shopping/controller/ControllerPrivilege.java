package com.institutohidrografico.shopping.controller;

import com.institutohidrografico.shopping.persistence.payload.request.DTORequestPrivilege;
import com.institutohidrografico.shopping.persistence.payload.response.DTOResponsePrivilege;
import com.institutohidrografico.shopping.service.ServicePrivilege;
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

@RestController @RequestMapping("/privilege") @RequiredArgsConstructor
public class ControllerPrivilege implements ControllerInterface<DTOResponsePrivilege, DTORequestPrivilege> {

    private final ServicePrivilege servicePrivilege;

    @PostMapping("") @Override @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<DTOResponsePrivilege> create(@RequestBody @Valid DTORequestPrivilege created){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/privilege").toUriString());
        return ResponseEntity.created(uri).body(servicePrivilege.create(created));
    }
    @GetMapping("") @Override @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponsePrivilege>> retrieve(@RequestParam(name = "key", defaultValue = "", required = false) String key, @RequestParam(name="value", defaultValue = "", required = false) String value, Pageable pageable){
        return ResponseEntity.ok().body(servicePrivilege.retrieve(pageable, key, value));
    }
    @PutMapping("") @Override @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<DTOResponsePrivilege> update(@RequestBody @Valid DTORequestPrivilege updated){
        return ResponseEntity.accepted().body(servicePrivilege.update(updated.getId(), updated));
    }
    @DeleteMapping("/{id}") @Override @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<DTOResponsePrivilege> delete(@PathVariable("id") UUID id){
        return ResponseEntity.accepted().body(servicePrivilege.delete(id));
    }
    @DeleteMapping("") @Override @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<HttpStatus> delete(){
        try {
            servicePrivilege.delete();
            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        }
    }
}