package com.institutohidrografico.shopping.controller;

import com.institutohidrografico.shopping.persistence.payload.request.DTORequestUser;
import com.institutohidrografico.shopping.persistence.payload.response.DTOResponseUser;
import com.institutohidrografico.shopping.service.ServiceUser;
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

@RestController @RequestMapping("/user") @RequiredArgsConstructor
public class ControllerUser implements ControllerInterface<DTOResponseUser, DTORequestUser> {

    private final ServiceUser serviceUser;

    @PostMapping("") @Override @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseUser> create(@RequestBody @Valid DTORequestUser created){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/user").toUriString());
        return ResponseEntity.created(uri).body(serviceUser.create(created));
    }
    @GetMapping("") @Override @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponseUser>> retrieve(@RequestParam(name = "key", defaultValue = "", required = false) String key, @RequestParam(name="value", defaultValue = "", required = false) String value, Pageable pageable){
        return ResponseEntity.ok().body(serviceUser.retrieve(pageable, key, value));
    }
    @PutMapping("") @Override @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseUser> update(@RequestBody @Valid DTORequestUser updated){
        return ResponseEntity.accepted().body(serviceUser.update(updated.getId(), updated));
    }
    @DeleteMapping("/{id}") @Override @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseUser> delete(@PathVariable("id") UUID id){
        return ResponseEntity.accepted().body(serviceUser.delete(id));
    }
    @DeleteMapping("") @Override @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<HttpStatus> delete(){
        try {
            serviceUser.delete();
            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/changePassword")
    public ResponseEntity<DTOResponseUser> changePassword(@RequestBody @Valid DTORequestUser updated){
        try {
            return new ResponseEntity<>(serviceUser.changePassword(updated), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}