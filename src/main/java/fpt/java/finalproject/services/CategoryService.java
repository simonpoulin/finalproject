package fpt.java.finalproject.services;

import java.util.List;

import fpt.java.finalproject.models.Category;

public interface CategoryService {

    public void save(Category entity) throws Exception;

    public Category findById(Integer id) throws Exception;

    public List<Category> findAll() throws Exception;

    public void deleteById(Integer id) throws Exception;

    public List<Category> saveAll(List<Category> entities);

    public boolean existsById(Integer id);

    public List<Category> findAllById(List<Integer> ids);

    public long count();

    public void delete(Category entity);

    public void deleteAll(List<Category> entities);

    public void deleteAll();

}
