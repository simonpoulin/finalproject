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
    public void save(Category entity) throws Exception {

        Category c = categoryRepository.save(entity);

        // Send error on fail
        if (c == null) {
            throw new Exception("Cannot save");
        }

    }

    @Override
    public Category findById(Integer id) throws Exception {

        Category c = new Category();

        // Find category
        Optional<Category> opts = categoryRepository.findById(id);

        // Set category
        if (opts.isPresent()) {
            c = opts.get();
        } else {
            // Send error on fail
            throw new Exception("Category not found");
        }

        return c;
    }

    @Override
    public List<Category> findAll() throws Exception {
        return (List<Category>) categoryRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) throws Exception {
        categoryRepository.deleteById(id);
    }

    @Override
    public List<Category> saveAll(List<Category> entities) {
        return (List<Category>) categoryRepository.saveAll(entities);
    }

    @Override
    public boolean existsById(Integer id) {
        return categoryRepository.existsById(id);
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
