package fpt.java.finalproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import fpt.java.finalproject.models.Employee;
import fpt.java.finalproject.repositories.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Override
    public List<Employee> customFind(String name) throws Exception {
        return employeeRepository.customFind(name);
    }

    @Override
    public Employee findByPhone(String phone) throws Exception {
        Employee e = new Employee();

        // Find employee
        Optional<Employee> opts = employeeRepository.findByPhone(phone);

        // Set employee
        if (opts.isPresent()) {
            e = opts.get();
        } else {
            // Send error on fail
            throw new Exception("Employee not found");
        }

        return e;
    }

    @Override
    public Employee findByUsername(String username) throws Exception {
        Employee e = new Employee();

        // Find employee
        Optional<Employee> opts = employeeRepository.findByUsername(username);

        // Set employee
        if (opts.isPresent()) {
            e = opts.get();
        } else {
            // Send error on fail
            throw new Exception("Employee not found");
        }

        return e;
    }

    @Override
    public Employee getAuthEmployee() {
        Employee e = new Employee();
        try {
            e = findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        } catch (Exception ex) {

        }
        return e;
    }

    @Override
    public void save(Employee entity) throws Exception {

        Employee e = employeeRepository.save(entity);

        // Send error on fail
        if (e == null) {
            throw new Exception("Cannot save");
        }

    }

    @Override
    public Employee findById(Integer id) throws Exception {

        Employee e = new Employee();

        // Find employee
        Optional<Employee> opts = employeeRepository.findById(id);

        // Set employee
        if (opts.isPresent()) {
            e = opts.get();
        } else {
            // Send error on fail
            throw new Exception("Employee not found");
        }

        return e;
    }

    @Override
    public void deleteById(Integer id) throws Exception {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> findAll() throws Exception {
        return (List<Employee>) employeeRepository.findAll();
    }

    @Override
    public List<Employee> saveAll(List<Employee> entities) {
        return (List<Employee>) employeeRepository.saveAll(entities);
    }

    @Override
    public boolean existsById(Integer id) {
        return employeeRepository.existsById(id);
    }

    @Override
    public List<Employee> findAllById(List<Integer> ids) {
        return (List<Employee>) employeeRepository.findAllById(ids);
    }

    @Override
    public long count() {
        return employeeRepository.count();
    }

    @Override
    public void delete(Employee entity) {
        employeeRepository.delete(entity);
    }

    @Override
    public void deleteAll(List<Employee> entities) {
        employeeRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        employeeRepository.deleteAll();
    }

}
