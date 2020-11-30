package fpt.java.finalproject.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fpt.java.finalproject.models.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    
    @Query(value = "exec search_employee :name", nativeQuery = true)
    List<Employee> customFind(@Param("name") String name);

    Optional<Employee> findByUsername(String username);

    Optional<Employee> findByPhone(String phone);
}
