package fpt.java.finalproject.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import fpt.java.finalproject.auth.EmployeeAuth;

public interface EmployeeDetailsService extends UserDetailsService {
    public EmployeeAuth loadUserByUsername(String username) throws UsernameNotFoundException;
}
