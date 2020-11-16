package fpt.java.finalproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fpt.java.finalproject.models.EmployeeRole;
import fpt.java.finalproject.repositories.EmployeeRoleRepository;

@Service
public class EmployeeRoleServiceImpl implements EmployeeRoleService {
    
    @Autowired
    private EmployeeRoleRepository employeeRoleRepository;

    @Override
    public EmployeeRole save(EmployeeRole entity) {
        return employeeRoleRepository.save(entity);
    }

    @Override
    public List<EmployeeRole> saveAll(List<EmployeeRole> entities) {
        return (List<EmployeeRole>) employeeRoleRepository.saveAll(entities);
    }

    @Override
    public EmployeeRole findById(Integer id) {
        EmployeeRole e = new EmployeeRole();

        // Find employee
        Optional<EmployeeRole> opts = employeeRoleRepository.findById(id);

        // Set employee
        if (opts.isPresent()) {
            e = opts.get();
        }

        return e;
    }

    @Override
    public boolean existsById(Integer id) {
        return employeeRoleRepository.existsById(id);
    }

    @Override
    public List<EmployeeRole> findAll() {
        return (List<EmployeeRole>) employeeRoleRepository.findAll();
    }

    @Override
    public List<EmployeeRole> findAllById(List<Integer> ids) {
        return (List<EmployeeRole>) employeeRoleRepository.findAllById(ids);
    }

    @Override
    public long count() {
        return employeeRoleRepository.count();
    }

    @Override
    public void deleteById(Integer id) {
        employeeRoleRepository.deleteById(id);
    }

    @Override
    public void delete(EmployeeRole entity) {
        employeeRoleRepository.delete(entity);
    }

    @Override
    public void deleteAll(List<EmployeeRole> entities) {
        employeeRoleRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        employeeRoleRepository.deleteAll();
    }

}
