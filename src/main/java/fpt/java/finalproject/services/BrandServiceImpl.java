package fpt.java.finalproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fpt.java.finalproject.models.Brand;
import fpt.java.finalproject.repositories.BrandRepository;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandRepository brandRepository;

    @Override
    public Brand save(Brand entity) {
        return brandRepository.save(entity);
    }

    @Override
    public List <Brand> saveAll(List<Brand> entities) {
        return (List<Brand>) brandRepository.saveAll(entities);
    }
    @Override
    public Optional<Brand> findById(Integer id) {
        return brandRepository.findById(id);
    }
    @Override
    public boolean existsById(Integer id) {
        return brandRepository.existsById(id);
    }
    @Override
    public List<Brand> findAll() {
        return (List<Brand>) brandRepository.findAll();
    }
    @Override
    public List<Brand> findAllById(List<Integer> ids) {
        return (List<Brand>) brandRepository.findAllById(ids);
    }
    @Override
    public long count() {
        return brandRepository.count();
    }
    @Override
    public void deleteById(Integer id) {
        brandRepository.deleteById(id);
    }
    @Override
    public void delete(Brand entity) {
        brandRepository.delete(entity);
    }
    @Override
    public void deleteAll(List <Brand> entities) {
        brandRepository.deleteAll(entities);
    }
    @Override
    public void deleteAll() {
        brandRepository.deleteAll();
    }
    
}
