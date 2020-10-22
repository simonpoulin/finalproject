package fpt.java.finalproject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fpt.java.finalproject.models.EmployeeRole;
@Repository
public interface EmployeeRoleRepository extends CrudRepository<EmployeeRole, Integer>{
    
}
