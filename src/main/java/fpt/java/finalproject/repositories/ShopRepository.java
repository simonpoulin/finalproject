package fpt.java.finalproject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fpt.java.finalproject.models.Shop;

@Repository
public interface ShopRepository extends CrudRepository<Shop, Integer> {
    
    @Query(value = "exec search_shop :name", nativeQuery = true)
    List<Shop> customFind(@Param("name") String name);

    @Query(value = "select * from shops limit :limit order by view_count desc", nativeQuery = true)
    List<Shop> getMostViewList(@Param("limit") Integer limit);

}
