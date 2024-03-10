package com.atasoy.examplewithchatgpt.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> roles = new HashSet<>();

    // UserDetails interface methods
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream().map(role -> (GrantedAuthority) () -> role).collect(Collectors.toList());
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Implement based on your requirements
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Implement based on your requirements
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Implement based on your requirements
    }

    @Override
    public boolean isEnabled() {
        return true; // Implement based on your requirements
    }
}
