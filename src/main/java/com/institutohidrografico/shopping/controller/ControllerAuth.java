package com.institutohidrografico.shopping.controller;

import com.institutohidrografico.shopping.persistence.payload.response.DTOResponseAuth;
import com.institutohidrografico.shopping.persistence.payload.request.DTORequestAuth;
import com.institutohidrografico.shopping.service.ServiceAuth;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController @RequestMapping("/auth") @RequiredArgsConstructor
public class ControllerAuth {

    private final ServiceAuth serviceAuth;

    @GetMapping("/ping")
    public String login(){
        return "ping";
    }
    @PostMapping("/login")
    public ResponseEntity<DTOResponseAuth> login(@RequestBody @Valid DTORequestAuth value){
        return ResponseEntity.accepted().body(serviceAuth.login(value));
    }
    @PostMapping("/logout")
    public ResponseEntity<HttpStatus> logout(@Valid @RequestBody DTORequestAuth dtoRequestAuth) {
        try {
            serviceAuth.logout(dtoRequestAuth);
            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        }
    }
}