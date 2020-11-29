package fpt.java.finalproject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fpt.java.finalproject.models.ShopPack;

@Repository
public interface ShopPackRepository extends CrudRepository<ShopPack, Integer> {
    @Query(value = "exec search_shoppack :name", nativeQuery = true)
    List<ShopPack> customFind(@Param("name") String name);
}
