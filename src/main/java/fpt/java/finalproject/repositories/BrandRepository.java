package fpt.java.finalproject.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fpt.java.finalproject.models.Brand;

@Repository
public interface BrandRepository extends CrudRepository<Brand , Integer> {
    List<Brand> findByBrandNameLikeOrderbyName(String brandName);
}
