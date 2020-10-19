package fpt.java.finalproject.services;

import java.util.List;
import java.util.Optional;

import fpt.java.finalproject.models.ShopItemImage;

public interface ShopItemImageService {

    public ShopItemImage  save(ShopItemImage entity) ;

    public List<ShopItemImage>  saveAll(List<ShopItemImage> entities) ;

    public Optional<ShopItemImage> findById(Integer id) ;

    public boolean existsById(Integer id) ;

    public Iterable<ShopItemImage> findAll() ;

    public List<ShopItemImage> findAllById(List<Integer> ids);

    public long count() ;

    public void deleteById(Integer id);

    public void delete(ShopItemImage entity) ;

    public void deleteAll(List<ShopItemImage> entities);

    public void deleteAll() ;
}
