package fpt.java.finalproject.services;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fpt.java.finalproject.auth.EmployeeAuth;
import fpt.java.finalproject.auth.EmployeeDetails;
import fpt.java.finalproject.models.Employee;

@Service
public class EmployeeDetailsServiceImpl implements EmployeeDetailsService {

    @Autowired
    private EmployeeService employeeService;

    @Override
    @Transactional
    public EmployeeAuth loadUserByUsername(String username) throws UsernameNotFoundException {

        Employee employee = new Employee();

        try {
            employee = employeeService.findByUsername(username);
        } catch (Exception e) {

        }

        if (employee == null) {
            throw new UsernameNotFoundException("User not found");
        }

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
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

        return new EmployeeDetails(employee, grantedAuthorities);
    }
}
