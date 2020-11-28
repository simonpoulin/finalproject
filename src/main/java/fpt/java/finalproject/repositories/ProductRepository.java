package fpt.java.finalproject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fpt.java.finalproject.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
    @Query(value    =   "SELECT * FROM products p ?1", nativeQuery = true)
    List<Product> customFind(String clause);
}
