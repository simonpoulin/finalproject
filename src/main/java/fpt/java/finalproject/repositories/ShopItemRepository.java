package fpt.java.finalproject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fpt.java.finalproject.models.ShopItem;

@Repository
public interface ShopItemRepository extends CrudRepository<ShopItem, Integer> {
    
    @Query(value = "exec search_item :categoryId, :brandId, :shopId, :productId", nativeQuery = true)
    List<ShopItem> customFind(@Param("categoryId") Integer categoryId, @Param("brandId") Integer brandId,
            @Param("shopId") Integer shopId, @Param("productId") Integer productId);

    @Query(value = "select * from shopitems order by view_count desc limit :limit" ,nativeQuery=true)
    List<ShopItem> getMostViewList(@Param("limit") Integer limit);

    @Query(value = "select * from shopitems order by sell_count desc limit :limit",nativeQuery=true)
    List<ShopItem> getMostSellList(@Param("limit") Integer limit);

}
