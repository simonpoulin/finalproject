package fpt.java.finalproject.utils;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import fpt.java.finalproject.models.Employee;
import fpt.java.finalproject.models.EmployeeRole;
import fpt.java.finalproject.repositories.EmployeeRepository;
import fpt.java.finalproject.repositories.EmployeeRoleRepository;

@Component
public class TestComponent implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeRoleRepository employeeRoleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent arg0) {

        // Admin account
        if (employeeRepository.findByUsername("a1") == null) {
            Employee admin = new Employee();
            admin.setUsername("a1");
            admin.setPassword(passwordEncoder.encode("123456"));
            admin.setAddress("address");
            admin.setCreatedAt(new Date(new Date().getTime()));
            admin.setEmail("email");
            admin.setName("name");
            admin.setPhone("phone");
            EmployeeRole employeeRole = employeeRoleRepository.findById(3).get();
            admin.setEmployeeRole(employeeRole);
            employeeRepository.save(admin);
        }

        // Manager account
        if (employeeRepository.findByUsername("a2") == null) {
            Employee manager = new Employee();
            manager.setUsername("a2");
            manager.setPassword(passwordEncoder.encode("123456"));
            manager.setAddress("address");
            manager.setCreatedAt(new Date(new Date().getTime()));
            manager.setEmail("email");
            manager.setName("name");
            manager.setPhone("phone");
            EmployeeRole employeeRole = employeeRoleRepository.findById(2).get();
            manager.setEmployeeRole(employeeRole);
            employeeRepository.save(manager);
        }

        // Admin account
        if (employeeRepository.findByUsername("a3") == null) {
            Employee employee = new Employee();
            employee.setUsername("a3");
            employee.setPassword(passwordEncoder.encode("123456"));
            employee.setAddress("address");
            employee.setCreatedAt(new Date(new Date().getTime()));
            employee.setEmail("email");
            employee.setName("name");
            employee.setPhone("phone");
            EmployeeRole employeeRole = employeeRoleRepository.findById(1).get();
            employee.setEmployeeRole(employeeRole);
            employeeRepository.save(employee);
        }
    }

}
