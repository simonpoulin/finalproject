package fpt.java.finalproject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fpt.java.finalproject.models.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {
    @Query(value = "exec search_category :name", nativeQuery = true)
    List<Category> customFind(@Param("name") String name);
}
