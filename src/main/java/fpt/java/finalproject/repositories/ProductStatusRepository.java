package fpt.java.finalproject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fpt.java.finalproject.models.ProductStatus;
@Repository
public interface ProductStatusRepository extends CrudRepository<ProductStatus, Integer> {
    
}
