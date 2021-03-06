package fpt.java.finalproject.services;

import java.util.List;

import fpt.java.finalproject.models.ShopPack;

public interface ShopPackService {

    public List<ShopPack> customFind(String name) throws Exception;
    
    public ShopPack save(ShopPack entity);

    public List<ShopPack> saveAll(List<ShopPack> entities);

    public ShopPack findById(Integer id);

    public boolean existsById(Integer id);

    public List<ShopPack> findAll();

    public List<ShopPack> findAllById(List<Integer> ids);

    public long count();

    public void deleteById(Integer id);

    public void delete(ShopPack entity);

    public void deleteAll(List<ShopPack> entities);

    public void deleteAll();
    
}
