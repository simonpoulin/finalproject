package fpt.java.finalproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fpt.java.finalproject.models.Product;
import fpt.java.finalproject.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Override
    public  Product  save(Product entity) {
        return productRepository.save(entity);
    }
    @Override
    public List<Product>  saveAll(List<Product> entities) {
        return (List<Product>) productRepository.saveAll(entities);
    }
    @Override
    public Optional<Product> findById(Integer id) {
        return productRepository.findById(id);
    }
    @Override
    public boolean existsById(Integer id) {
        return productRepository.existsById(id);
    }
    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }
    @Override
    public List<Product> findAllById(List<Integer> ids) {
        return (List<Product>) productRepository.findAllById(ids);
    }
    @Override
    public long count() {
        return productRepository.count();
    }
    @Override
    public void deleteById(Integer id) {
        productRepository.deleteById(id);
    }
    @Override
    public void delete(Product entity) {
        productRepository.delete(entity);
    }
    @Override
    public void deleteAll(List<Product> entities) {
        productRepository.deleteAll(entities);
    }
    @Override
    public void deleteAll() {
        productRepository.deleteAll();
    }

    
}
