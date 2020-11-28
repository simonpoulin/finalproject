package fpt.java.finalproject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fpt.java.finalproject.models.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {
    @Query(value    =   "SELECT * FROM categories p ?1", nativeQuery = true)
    List<Category> customFind(String clause);
}
