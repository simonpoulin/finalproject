package fpt.java.finalproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fpt.java.finalproject.models.Employee;
import fpt.java.finalproject.repositories.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee save(Employee entity) {
        return employeeRepository.save(entity);
    }

    @Override
    public List<Employee> saveAll(List<Employee> entities) {
        return (List<Employee>) employeeRepository.saveAll(entities);
    }

    @Override
    public Optional<Employee> findById(Integer id) {
        return employeeRepository.findById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        return employeeRepository.existsById(id);
    }

    @Override
    public List<Employee> findAll() {
        return (List<Employee>) employeeRepository.findAll();
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
    public void deleteById(Integer id) {
        employeeRepository.deleteById(id);
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
