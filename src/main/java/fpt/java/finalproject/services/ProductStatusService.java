package fpt.java.finalproject.services;

import java.util.List;
import java.util.Optional;

import fpt.java.finalproject.models.ProductStatus;

public interface ProductStatusService {

    public  ProductStatus save(ProductStatus entity);

    public List<ProductStatus> saveAll(List<ProductStatus> entities);

    public Optional<ProductStatus> findById(Integer id) ;

    public boolean existsById(Integer id) ;

    public Iterable<ProductStatus> findAll() ;

    public List<ProductStatus> findAllById(List<Integer> ids);
    
    public long count() ;

    public void deleteById(Integer id);

    public void delete(ProductStatus entity);

    public void deleteAll(List <ProductStatus> entities);

    public void deleteAll() ;
    
}
