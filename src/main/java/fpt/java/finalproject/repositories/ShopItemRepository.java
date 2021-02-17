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

    @Query(value = "select * from shopitems limit :limit order by view_count desc ", nativeQuery = true)
    List<ShopItem> getMostViewList(@Param("limit") Integer limit);

    @Query(value = "select * from shopitems limit :limit order by sell_count desc", nativeQuery = true)
    List<ShopItem> getMostSellList(@Param("limit") Integer limit);

    @Query(value = "exec user_search_item :title, :categoryId, :shopId, :sort", nativeQuery = true)
    List<ShopItem> customFind(@Param("title") String title, @Param("categoryId") Integer categoryId, @Param("sort") boolean sort);

    @Query(value = "select * from shopitems s inner join products p on p.id = s.product_id where p.category_id = :categoryId limit 5 order by s.id asc ", nativeQuery = true)
    List<ShopItem> customFindByCategoryId(@Param("categoryId") Integer categoryId);

}
