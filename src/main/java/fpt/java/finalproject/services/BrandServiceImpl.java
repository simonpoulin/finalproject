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
    public void save(Brand entity) throws Exception {

        Brand b = brandRepository.save(entity);

        // Send error on fail
        if (b == null) {
            throw new Exception("Cannot save");
        }

    }

    @Override
    public Brand findById(Integer id) throws Exception {

        Brand b = new Brand();

        // Find brand
        Optional<Brand> opts = brandRepository.findById(id);

        // Set brand
        if (opts.isPresent()) {
            b = opts.get();
        } else {
            // Send error on fail
            throw new Exception("Brand not found");
        }

        return b;
    }

    @Override
    public List<Brand> findAll() {
        return (List<Brand>) brandRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) throws Exception {
        brandRepository.deleteById(id);
    }

    @Override
    public List<Brand> saveAll(List<Brand> entities) {
        return (List<Brand>) brandRepository.saveAll(entities);
    }

    @Override
    public List<Brand> findAllById(List<Integer> ids) {
        return (List<Brand>) brandRepository.findAllById(ids);
    }

    @Override
    public boolean existsById(Integer id) {
        return brandRepository.existsById(id);
    }

    @Override
    public long count() {
        return brandRepository.count();
    }

    @Override
    public void delete(Brand entity) {
        brandRepository.delete(entity);
    }

    @Override
    public void deleteAll(List<Brand> entities) {
        brandRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        brandRepository.deleteAll();
    }

}
