package fpt.java.finalproject.services;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fpt.java.finalproject.models.Employee;
import fpt.java.finalproject.models.EmployeeDetails;
import fpt.java.finalproject.models.EmployeeDetailsIntf;
import fpt.java.finalproject.repositories.EmployeeRepository;

@Service
public class EmployeeDetailsServiceImpl implements EmployeeDetailsService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Employee employee = employeeRepository.findByUsername(username);
        if (employee == null) {
            throw new UsernameNotFoundException("User not found");
        }

        Collection<GrantedAuthority> grantedAuthorities = new HashSet<>();
        int role = employee.getEmployeeRole().getId();

        if (role >= 1) {
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_EMPLOYEE"));
        }

        if (role >= 2) {
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_MANAGER"));
        }

        if (role == 3) {
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }

        return new EmployeeDetails(employee.getUsername(), employee.getPassword(), grantedAuthorities);
    }
}
