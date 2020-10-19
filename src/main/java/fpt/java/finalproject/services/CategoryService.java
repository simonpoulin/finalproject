package fpt.java.finalproject.services;

import java.util.List;
import java.util.Optional;

import fpt.java.finalproject.models.Category;

public interface CategoryService {
    public Category save(Category entity);
    
    public List<Category> saveAll(List<Category> entities) ;

    public Optional<Category> findById(Integer id);

    public boolean existsById(Integer id) ;

    public Iterable<Category> findAll();

    public List<Category> findAllById(List<Integer> ids);

    public long count() ;

    public void deleteById(Integer id);

    public void delete(Category entity) ;

    public void deleteAll(List<Category> entities) ;
    
    public void deleteAll(); 
}
