package fpt.java.finalproject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fpt.java.finalproject.models.ShopRole;

@Repository
public interface ShopRoleRepository extends CrudRepository<ShopRole, Integer> {

}
