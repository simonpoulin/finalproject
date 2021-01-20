package fpt.java.finalproject.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fpt.java.finalproject.models.ShopEmployee;

@Repository
public interface ShopEmployeeRepository extends CrudRepository<ShopEmployee, Integer> {
    List<ShopEmployee> findByUserId(Integer id);
}
