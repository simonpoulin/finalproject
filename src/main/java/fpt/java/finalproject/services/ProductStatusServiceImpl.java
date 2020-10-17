package fpt.java.finalproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fpt.java.finalproject.models.ProductStatus;
import fpt.java.finalproject.repositories.ProductStatusRepository;


@Service
public class ProductStatusServiceImpl implements ProductStatusService {
    @Autowired
    private ProductStatusRepository productStatusRepository;
    @Override
    public  ProductStatus save(ProductStatus entity) {
        return productStatusRepository.save(entity);
    }
    @Override
    public List<ProductStatus> saveAll(List<ProductStatus> entities) {
        return (List<ProductStatus>) productStatusRepository.saveAll(entities);
    }
    @Override
    public Optional<ProductStatus> findById(Integer id) {
        return productStatusRepository.findById(id);
    }
    @Override
    public boolean existsById(Integer id) {
        return productStatusRepository.existsById(id);
    }
    @Override
    public Iterable<ProductStatus> findAll() {
        return productStatusRepository.findAll();
    }
    @Override
    public List<ProductStatus> findAllById(List<Integer> ids) {
        return (List<ProductStatus>) productStatusRepository.findAllById(ids);
    }
    @Override
    public long count() {
        return productStatusRepository.count();
    }
    @Override
    public void deleteById(Integer id) {
        productStatusRepository.deleteById(id);
    }
    @Override
    public void delete(ProductStatus entity) {
        productStatusRepository.delete(entity);
    }
    @Override
    public void deleteAll(List <ProductStatus> entities) {
        productStatusRepository.deleteAll(entities);
    }
    @Override
    public void deleteAll() {
        productStatusRepository.deleteAll();
    }

    
}
