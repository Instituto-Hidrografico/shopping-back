package com.institutohidrografico.shopping.service;

import com.institutohidrografico.shopping.persistence.model.Privilege;
import com.institutohidrografico.shopping.persistence.model.Role;
import com.institutohidrografico.shopping.persistence.model.User;
import com.institutohidrografico.shopping.persistence.repository.RepositoryRole;
import com.institutohidrografico.shopping.persistence.repository.RepositoryUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service @RequiredArgsConstructor
public class ServiceCustomUserDetails implements UserDetailsService {

    private final RepositoryUser repositoryUser;
    private final RepositoryRole repositoryRole;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repositoryUser.findByUsername(username).orElse(null);
//        if (user == null) {
//            return new org.springframework.security.core.userdetails.User(
//                    " ", " ", true, true, true, true,
//                    getAuthorities(Collections.singletonList(repositoryRole.findByName("ROLE_USER"))));
//        }
        return new org.springframework.security.core.userdetails.User(Objects.requireNonNull(user).getUsername(), user.getPassword(), getAuthorities(user.getRoles()));
    }
    private Collection<? extends GrantedAuthority> getAuthorities(Collection<Role> roles) {
        return getGrantedAuthorities(getPrivileges(roles));
    }
    private List<String> getPrivileges(Collection<Role> roles) {
        List<String> privileges = new ArrayList<>();
        List<Privilege> collection = new ArrayList<>();
        for (Role role : roles) {
            privileges.add(role.getName());
            collection.addAll(role.getPrivileges());
        }
        for (Privilege item : collection) {
            privileges.add(item.getName());
        }
        return privileges;
    }
    private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String privilege : privileges) {
            authorities.add(new SimpleGrantedAuthority(privilege));
        }
        return authorities;
    }
}