package com.institutohidrografico.shopping.controller;

import com.institutohidrografico.shopping.persistence.payload.request.DTORequestState;
import com.institutohidrografico.shopping.persistence.payload.response.DTOResponseState;
import com.institutohidrografico.shopping.service.ServiceState;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;
import java.net.URI;

@RestController @RequestMapping("/state") @RequiredArgsConstructor
public class ControllerState {

    private final ServiceState serviceState;

    @PostMapping("") @PreAuthorize("hasAnyRole('52c57a80-4e3b-4a41-a864-58d0cea25b14', '8652ec73-0a53-433c-93be-420f1d90c681')")
    public ResponseEntity<DTOResponseState> create(@RequestBody @Valid DTORequestState created){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/state").toUriString());
        return ResponseEntity.created(uri).body(serviceState.create(created));
    }
    @GetMapping("") @PreAuthorize("hasAnyRole('USER', '52c57a80-4e3b-4a41-a864-58d0cea25b14', '8652ec73-0a53-433c-93be-420f1d90c681')")
    public ResponseEntity<Page<DTOResponseState>> retrieve(@RequestParam(name = "key", defaultValue = "", required = false) String key, @RequestParam(name="value", defaultValue = "", required = false) String value, Pageable pageable){
        return ResponseEntity.ok().body(serviceState.retrieve(pageable, key, value));
    }
    @PutMapping("") @PreAuthorize("hasAnyRole('52c57a80-4e3b-4a41-a864-58d0cea25b14', '8652ec73-0a53-433c-93be-420f1d90c681')")
    public ResponseEntity<DTOResponseState> update(@RequestBody @Valid DTORequestState updated){
        return ResponseEntity.accepted().body(serviceState.update(updated.getId(), updated));
    }
    @DeleteMapping("/{id}") @PreAuthorize("hasAnyRole('52c57a80-4e3b-4a41-a864-58d0cea25b14', '8652ec73-0a53-433c-93be-420f1d90c681')")
    public ResponseEntity<DTOResponseState> delete(@PathVariable long id){
        return ResponseEntity.accepted().body(serviceState.delete(id));
    }
    @DeleteMapping("") @PreAuthorize("hasAnyRole('52c57a80-4e3b-4a41-a864-58d0cea25b14', '8652ec73-0a53-433c-93be-420f1d90c681')")
    public ResponseEntity<HttpStatus> delete(){
        try {
            serviceState.delete();
            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        }
    }
}