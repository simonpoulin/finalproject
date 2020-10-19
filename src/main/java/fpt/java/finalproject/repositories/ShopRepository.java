package fpt.java.finalproject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fpt.java.finalproject.models.Shop;
@Repository
public interface ShopRepository extends CrudRepository<Shop , Integer>{
    
}
