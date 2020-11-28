package fpt.java.finalproject.services;

import java.util.List;

import fpt.java.finalproject.models.Brand;

public interface BrandService {

    public List<Brand> customFind(String clause) throws Exception;
    
    public void save(Brand entity) throws Exception;

    public Brand findById(Integer id) throws Exception;

    public List<Brand> findAll();

    public void deleteById(Integer id) throws Exception;

    public List<Brand> saveAll(List<Brand> entities);

    public boolean existsById(Integer id);

    public List<Brand> findAllById(List<Integer> ids);

    public long count();

    public void delete(Brand entity);

    public void deleteAll(List<Brand> entities);

    public void deleteAll();

}
