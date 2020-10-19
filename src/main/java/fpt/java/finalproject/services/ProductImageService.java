package fpt.java.finalproject.services;

import java.util.List;
import java.util.Optional;

import fpt.java.finalproject.models.ProductImage;

public interface ProductImageService {
    
    public  ProductImage save(ProductImage entity) ;

    public List<ProductImage>  saveAll(List<ProductImage> entities) ;

    public Optional<ProductImage> findById(Integer id);

    public boolean existsById(Integer id);

    public Iterable<ProductImage> findAll();
    
    public List<ProductImage> findAllById(List<Integer> ids);

    public long count();
    
    public void deleteById(Integer id) ;

    public void delete(ProductImage entity);

    public void deleteAll(List <ProductImage> entities);
    
    public void deleteAll() ;
}
