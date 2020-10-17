package fpt.java.finalproject.services;

import java.util.List;
import java.util.Optional;

import fpt.java.finalproject.models.Brand;

public interface BrandService {
    
    public Brand save(Brand entity);

    public List <Brand> saveAll(List<Brand> entities);

    public Optional<Brand> findById(Integer id) ;

    public boolean existsById(Integer id) ;

    public List<Brand> findAll();

    public List<Brand> findAllById(List<Integer> ids);

    public long count();

    public void deleteById(Integer id) ;

    public void delete(Brand entity);

    public void deleteAll(List <Brand> entities) ;

    public void deleteAll() ;
}
