package com.institutohidrografico.shopping.controller;

import com.institutohidrografico.shopping.persistence.payload.request.DTORequestLocation;
import com.institutohidrografico.shopping.persistence.payload.response.DTOResponseLocation;
import com.institutohidrografico.shopping.service.ServiceLocation;
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

@RestController @RequestMapping("/location") @RequiredArgsConstructor
public class ControllerLocation implements ControllerInterface<DTOResponseLocation, DTORequestLocation> {

    private final ServiceLocation serviceLocation;

    @PostMapping("") @PreAuthorize("hasAnyRole('52c57a80-4e3b-4a41-a864-58d0cea25b14', '8652ec73-0a53-433c-93be-420f1d90c681')")
    public ResponseEntity<DTOResponseLocation> create(@RequestBody @Valid DTORequestLocation created){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/location").toUriString());
        return ResponseEntity.created(uri).body(serviceLocation.create(created));
    }
    @GetMapping("") @PreAuthorize("hasAnyRole('USER', '52c57a80-4e3b-4a41-a864-58d0cea25b14', '8652ec73-0a53-433c-93be-420f1d90c681')")
    public ResponseEntity<Page<DTOResponseLocation>> retrieve(@RequestParam(name = "key", defaultValue = "", required = false) String key, @RequestParam(name="value", defaultValue = "", required = false) String value, Pageable pageable){
        return ResponseEntity.ok().body(serviceLocation.retrieve(pageable, key, value));
    }
    @PutMapping("") @PreAuthorize("hasAnyRole('52c57a80-4e3b-4a41-a864-58d0cea25b14', '8652ec73-0a53-433c-93be-420f1d90c681')")
    public ResponseEntity<DTOResponseLocation> update(@RequestBody @Valid DTORequestLocation updated){
        return ResponseEntity.accepted().body(serviceLocation.update(updated.getId(), updated));
    }
    @DeleteMapping("/{id}") @PreAuthorize("hasAnyRole('52c57a80-4e3b-4a41-a864-58d0cea25b14', '8652ec73-0a53-433c-93be-420f1d90c681')")
    public ResponseEntity<DTOResponseLocation> delete(@PathVariable UUID id){
        return ResponseEntity.accepted().body(serviceLocation.delete(id));
    }
    @DeleteMapping("") @PreAuthorize("hasAnyRole('52c57a80-4e3b-4a41-a864-58d0cea25b14', '8652ec73-0a53-433c-93be-420f1d90c681')")
    public ResponseEntity<HttpStatus> delete(){
        try {
            serviceLocation.delete();
            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        }
    }
}