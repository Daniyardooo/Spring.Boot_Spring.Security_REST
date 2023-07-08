package ru.kata.spring.boot_security.demo.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kata.spring.boot_security.demo.models.Role;

import java.util.Collection;

public interface CustomUserDetails extends UserDetailsService {

    void setUserService(UserServiceImpl userServiceImpl);

    UserDetails loadUserByUsername(String username);

    Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles);
}
