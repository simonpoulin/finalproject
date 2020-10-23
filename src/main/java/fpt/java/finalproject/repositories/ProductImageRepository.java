package fpt.java.finalproject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fpt.java.finalproject.models.ProductImage;

@Repository
public interface ProductImageRepository extends CrudRepository<ProductImage, Integer> {

}
