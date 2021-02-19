package fpt.java.finalproject.services;

import java.util.List;

import fpt.java.finalproject.dtos.ShopItemDto;
import fpt.java.finalproject.models.ShopItem;

public interface ShopItemService {

    public List<ShopItem> getMostViewList(Integer limit) throws Exception;

    public List<ShopItem> getMostSellList(Integer limit) throws Exception;

    public List<ShopItem> customFind(Integer categoryId, Integer brandId, Integer shopId, Integer productId) throws Exception;

    public void save(ShopItemDto entity) throws Exception;

    public List<ShopItem> saveAll(List<ShopItem> entities);

    public ShopItem findById(Integer id) throws Exception;

    public boolean existsById(Integer id);

    public List<ShopItem> findAll();

    public List<ShopItem> findAllById(List<Integer> ids);

    public long count();

    public void deleteById(Integer id) throws Exception;

    public void delete(ShopItem entity);

    public void deleteAll(List<ShopItem> entities);

    public void deleteAll();
}
