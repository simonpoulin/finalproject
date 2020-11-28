package fpt.java.finalproject.services;

import java.util.List;

import fpt.java.finalproject.models.Employee;

public interface EmployeeService {

    public List<Employee> customFind(String clause) throws Exception;
    
    public Employee getAuthEmployee();

    public Employee findByPhone(String phone) throws Exception;

    public Employee findByUsername(String username) throws Exception;

    public void save(Employee entity) throws Exception;

    public List<Employee> findAll() throws Exception;

    public Employee findById(Integer id) throws Exception;

    public void deleteById(Integer id) throws Exception;

    public List<Employee> saveAll(List<Employee> entities);

    public boolean existsById(Integer id);

    public List<Employee> findAllById(List<Integer> ids);

    public long count();

    public void delete(Employee entity);

    public void deleteAll(List<Employee> entities);

    public void deleteAll();
}
