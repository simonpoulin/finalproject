package fpt.java.finalproject.services;

import java.util.List;
import java.util.Optional;

import fpt.java.finalproject.models.Product;

public interface ProductService {

    public  Product  save(Product entity) ;

    public List<Product>  saveAll(List<Product> entities) ;

    public Optional<Product> findById(Integer id);

    public boolean existsById(Integer id);


    public Iterable<Product> findAll();

    public List<Product> findAllById(List<Integer> ids);

    public long count() ;

    public void deleteById(Integer id);

    public void delete(Product entity) ;

    public void deleteAll(List<Product> entities);

    public void deleteAll() ;
}
