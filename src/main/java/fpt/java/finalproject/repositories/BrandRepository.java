package fpt.java.finalproject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fpt.java.finalproject.models.Brand;

@Repository
public interface BrandRepository extends CrudRepository<Brand, Integer> {
    @Query(value = "exec search_brand :name", nativeQuery = true)
    List<Brand> customFind(@Param("name") String name);
}
