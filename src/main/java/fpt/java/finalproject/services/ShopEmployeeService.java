package fpt.java.finalproject.services;

import java.util.List;
import java.util.Optional;

import fpt.java.finalproject.models.ShopEmployee;

public interface ShopEmployeeService {

    public List<ShopEmployee> findByUserId(Integer id) throws Exception;

    public ShopEmployee save(ShopEmployee entity);

    public List<ShopEmployee> saveAll(List<ShopEmployee> entities);

    public Optional<ShopEmployee> findById(Integer id);

    public boolean existsById(Integer id);

    public List<ShopEmployee> findAll();

    public List<ShopEmployee> findAllById(List<Integer> ids);

    public long count();

    public void deleteById(Integer id);

    public void delete(ShopEmployee entity);

    public void deleteAll(List<ShopEmployee> entities);

    public void deleteAll();

}
