package fpt.java.finalproject.services;

import java.util.List;
import java.util.Optional;

import fpt.java.finalproject.models.Employee;

public interface EmployeeService {

    public  Employee  save(Employee entity);

    public List<Employee> saveAll(List<Employee> entities) ;

    public Optional<Employee> findById(Integer id) ;

    public boolean existsById(Integer id) ;

    public List<Employee> findAll();

    public List<Employee> findAllById(List<Integer> ids) ;

    public long count() ;

    public void deleteById(Integer id);

    public void delete(Employee entity);

    public void deleteAll(List<Employee> entities) ;
    
    public void deleteAll();
}
