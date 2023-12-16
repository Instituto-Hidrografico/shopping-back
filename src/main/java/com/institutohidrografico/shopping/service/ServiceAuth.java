package com.institutohidrografico.shopping.service;

import com.institutohidrografico.shopping.persistence.payload.request.DTORequestAuth;
import com.institutohidrografico.shopping.persistence.payload.response.DTOResponseAuth;
import com.institutohidrografico.shopping.security.JWTGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service @RequiredArgsConstructor
public class ServiceAuth {

    private final AuthenticationManager authenticationManager;
    private final JWTGenerator jwtGenerator;
    @Autowired
    private ServiceCustomUserDetails serviceCustomUserDetails;

    public DTOResponseAuth login(DTORequestAuth dtoRequestAuth) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dtoRequestAuth.getUsername(), dtoRequestAuth.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails = serviceCustomUserDetails.loadUserByUsername(dtoRequestAuth.getUsername());
        String token = jwtGenerator.generateToken(authentication);
        List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority()).collect(Collectors.toList());
        return new DTOResponseAuth(token, "Bearer ", roles);
    }

    public void logout(DTORequestAuth value) {
//        serviceRefreshToken.deleteByUserId(value.getUserId());
    }
}