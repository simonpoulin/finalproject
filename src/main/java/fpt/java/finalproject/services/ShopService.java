package fpt.java.finalproject.services;

import java.util.List;
import java.util.Optional;

import fpt.java.finalproject.models.Shop;

public interface ShopService {

    public void save(Shop entity) throws Exception;

    public List<Shop> saveAll(List<Shop> entities);

    public Shop findById(Integer id) throws Exception ;

    public boolean existsById(Integer id);

    public List<Shop> findAll() throws Exception;

    public List<Shop> findAllById(List<Integer> ids);

    public long count();

    public void deleteById(Integer id) throws Exception;

    public void delete(Shop entity);

    public void deleteAll(List<Shop> entities);

    public void deleteAll();

}
