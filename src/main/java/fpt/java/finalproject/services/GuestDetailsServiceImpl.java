package fpt.java.finalproject.services;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fpt.java.finalproject.auth.GuestAuth;
import fpt.java.finalproject.auth.GuestDetails;
import fpt.java.finalproject.models.User;

@Service
public class GuestDetailsServiceImpl implements GuestDetailsService {

    @Autowired
    private UserService userService;

    @Override
    @Transactional
    public GuestAuth loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = new User();

        try {
            user = userService.findByUsername(username);
        } catch (Exception e) {

        }

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        return new GuestDetails(user, grantedAuthorities);
    }
}
