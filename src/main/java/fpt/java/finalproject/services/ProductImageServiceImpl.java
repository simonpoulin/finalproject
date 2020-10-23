package fpt.java.finalproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fpt.java.finalproject.models.ProductImage;
import fpt.java.finalproject.repositories.ProductImageRepository;

@Service
public class ProductImageServiceImpl implements ProductImageService {

    @Autowired
    private ProductImageRepository productImageRepository;

    @Override
    public ProductImage save(ProductImage entity) {
        return productImageRepository.save(entity);
    }

    @Override
    public List<ProductImage> saveAll(List<ProductImage> entities) {
        return (List<ProductImage>) productImageRepository.saveAll(entities);
    }

    @Override
    public Optional<ProductImage> findById(Integer id) {
        return productImageRepository.findById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        return productImageRepository.existsById(id);
    }

    @Override
    public List<ProductImage> findAll() {
        return (List<ProductImage>) productImageRepository.findAll();
    }

    @Override
    public List<ProductImage> findAllById(List<Integer> ids) {
        return (List<ProductImage>) productImageRepository.findAllById(ids);
    }

    @Override
    public long count() {
        return productImageRepository.count();
    }

    @Override
    public void deleteById(Integer id) {
        productImageRepository.deleteById(id);
    }

    @Override
    public void delete(ProductImage entity) {
        productImageRepository.delete(entity);
    }

    @Override
    public void deleteAll(List<ProductImage> entities) {
        productImageRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        productImageRepository.deleteAll();
    }

}
