package fpt.java.finalproject.services;

import java.util.List;

import fpt.java.finalproject.DTOS.ProductDto;
import fpt.java.finalproject.models.Product;

public interface ProductService {

    public List<Product> customFind(String name, Integer categoryId, Integer brandId) throws Exception;

    public void save(ProductDto entity) throws Exception;

    public List<Product> saveAll(List<Product> entities);

    public Product findById(Integer id) throws Exception;

    public boolean existsById(Integer id);

    public List<Product> findAll();

    public List<Product> findAllById(List<Integer> ids);

    public long count();

    public void deleteById(Integer id) throws Exception;

    public void delete(Product entity);

    public void deleteAll(List<Product> entities);

    public void deleteAll();
    
}
