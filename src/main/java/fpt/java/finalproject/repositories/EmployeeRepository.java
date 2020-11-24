package fpt.java.finalproject.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fpt.java.finalproject.models.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    Optional<Employee> findByUsername(String username);

    Optional<Employee> findByPhone(String phone);
}
