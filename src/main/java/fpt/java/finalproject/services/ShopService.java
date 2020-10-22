package fpt.java.finalproject.services;

import java.util.List;
import java.util.Optional;

import fpt.java.finalproject.models.Shop;

public interface ShopService {

    public  Shop save(Shop entity) ;

    public List<Shop> saveAll(List<Shop> entities);

    public Optional<Shop> findById(Integer id) ;

    public boolean existsById(Integer id);

    public List<Shop> findAll();

    public List<Shop> findAllById(List<Integer> ids);

    public long count() ;

    public void deleteById(Integer id);

    public void delete(Shop entity);

    public void deleteAll(List<Shop> entities);

    public void deleteAll() ;
    
}
