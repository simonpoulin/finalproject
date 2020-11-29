package fpt.java.finalproject.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import fpt.java.finalproject.auth.GuestAuth;

public interface GuestDetailsService extends UserDetailsService {
    public GuestAuth loadUserByUsername(String username) throws UsernameNotFoundException;
}
