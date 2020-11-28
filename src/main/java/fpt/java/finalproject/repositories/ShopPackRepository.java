package fpt.java.finalproject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fpt.java.finalproject.models.ShopPack;

@Repository
public interface ShopPackRepository extends CrudRepository<ShopPack, Integer> {
    @Query(value    =   "SELECT * FROM shoppacks p ?1", nativeQuery = true)
    List<ShopPack> customFind(String clause);
}
