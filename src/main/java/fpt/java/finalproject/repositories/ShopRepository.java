package fpt.java.finalproject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fpt.java.finalproject.models.Shop;

@Repository
public interface ShopRepository extends CrudRepository<Shop, Integer> {
    @Query(value    =   "SELECT * FROM shops p ?1", nativeQuery = true)
    List<Shop> customFind(String clause);
}
