package fpt.java.finalproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fpt.java.finalproject.models.Category;
import fpt.java.finalproject.repositories.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public Category save(Category entity) {
        return categoryRepository.save(entity);
    }
    @Override
    public List <Category> saveAll(List<Category> entities) {
        return (List<Category>) categoryRepository.saveAll(entities);
    }
    @Override
    public Optional<Category> findById(Integer id) {
        return categoryRepository.findById(id);
    }
    @Override
    public boolean existsById(Integer id) {
        return categoryRepository.existsById(id);
    }
    @Override
    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }
    @Override
    public List<Category> findAllById(List<Integer> ids) {
        return (List<Category>) categoryRepository.findAllById(ids);
    }
    @Override
    public long count() {
        return categoryRepository.count();
    }
    @Override
    public void deleteById(Integer id) {
        categoryRepository.deleteById(id);
    }
    @Override
    public void delete(Category entity) {
        categoryRepository.delete(entity);
    }
    @Override
    public void deleteAll(List<Category> entities) {
        categoryRepository.deleteAll(entities);
    }
    @Override
    public void deleteAll() {
        categoryRepository.deleteAll();
    }

    
}