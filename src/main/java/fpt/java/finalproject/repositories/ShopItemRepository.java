package fpt.java.finalproject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fpt.java.finalproject.models.ShopItem;

@Repository
public interface ShopItemRepository extends CrudRepository<ShopItem, Integer> {
    @Query(value    =   "SELECT * FROM shopitems p ?1", nativeQuery = true)
    List<ShopItem> customFind(String clause);
}
