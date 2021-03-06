package fpt.java.finalproject.services;

import java.util.List;
import java.util.Optional;

import fpt.java.finalproject.models.ShopRole;

public interface ShopRoleService {

    public ShopRole save(ShopRole entity);

    public List<ShopRole> saveAll(List<ShopRole> entities);

    public ShopRole findById(Integer id) throws Exception;

    public boolean existsById(Integer id);

    public List<ShopRole> findAll();

    public List<ShopRole> findAllById(List<Integer> ids);

    public long count();

    public void deleteById(Integer id);

    public void delete(ShopRole entity);

    public void deleteAll(List<ShopRole> entities);

    public void deleteAll();

}
