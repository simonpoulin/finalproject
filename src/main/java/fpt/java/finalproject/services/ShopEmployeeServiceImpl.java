package fpt.java.finalproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fpt.java.finalproject.models.ShopEmployee;
import fpt.java.finalproject.repositories.ShopEmployeeRepository;

@Service
public class ShopEmployeeServiceImpl implements ShopEmployeeService {
    
    @Autowired
    private ShopEmployeeRepository shopEmployeeRepository;

    @Override
    public ShopEmployee save(ShopEmployee entity) {
        return shopEmployeeRepository.save(entity);
    }

    @Override
    public List<ShopEmployee> saveAll(List<ShopEmployee> entities) {
        return (List<ShopEmployee>) shopEmployeeRepository.saveAll(entities);
    }

    @Override
    public Optional<ShopEmployee> findById(Integer id) {
        return shopEmployeeRepository.findById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        return shopEmployeeRepository.existsById(id);
    }

    @Override
    public List<ShopEmployee> findAll() {
        return (List<ShopEmployee>) shopEmployeeRepository.findAll();
    }

    @Override
    public List<ShopEmployee> findAllById(List<Integer> ids) {
        return (List<ShopEmployee>) shopEmployeeRepository.findAllById(ids);
    }

    @Override
    public long count() {
        return shopEmployeeRepository.count();
    }

    @Override
    public void deleteById(Integer id) {
        shopEmployeeRepository.deleteById(id);
    }

    @Override
    public void delete(ShopEmployee entity) {
        shopEmployeeRepository.delete(entity);
    }

    @Override
    public void deleteAll(List<ShopEmployee> entities) {
        shopEmployeeRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        shopEmployeeRepository.deleteAll();
    }
}
