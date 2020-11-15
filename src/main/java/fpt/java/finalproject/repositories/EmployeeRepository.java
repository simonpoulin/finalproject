package fpt.java.finalproject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fpt.java.finalproject.models.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    Employee findByUsername(String username);
}
