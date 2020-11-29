package fpt.java.finalproject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fpt.java.finalproject.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
    @Query(value = "exec search_product :name, :categoryId, :brandId", nativeQuery = true)
    List<Product> customFind(@Param("name") String name, @Param("categoryId") Integer categoryId, @Param("brandId") Integer brandId);
}
