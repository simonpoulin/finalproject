package fpt.java.finalproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fpt.java.finalproject.models.ShopRole;
import fpt.java.finalproject.repositories.ShopRoleRepository;

@Service
public class ShopRoleServiceImpl implements ShopRoleService {
    
    @Autowired
    private ShopRoleRepository shopRoleRepository;

    @Override
    public ShopRole save(ShopRole entity) {
        return shopRoleRepository.save(entity);
    }

    @Override
    public List<ShopRole> saveAll(List<ShopRole> entities) {
        return (List<ShopRole>) shopRoleRepository.saveAll(entities);
    }

    @Override
    public ShopRole findById(Integer id) throws Exception{
        ShopRole sr;
        Optional<ShopRole> opts = shopRoleRepository.findById(id);
        if (opts.isPresent()) {
            sr = opts.get();
        } else {
            throw new Exception("Shop role not found");
        }
        return sr;
    }

    @Override
    public boolean existsById(Integer id) {
        return shopRoleRepository.existsById(id);
    }

    @Override
    public List<ShopRole> findAll() {
        return (List<ShopRole>) shopRoleRepository.findAll();
    }

    @Override
    public List<ShopRole> findAllById(List<Integer> ids) {
        return (List<ShopRole>) shopRoleRepository.findAllById(ids);
    }

    @Override
    public long count() {
        return shopRoleRepository.count();
    }

    @Override
    public void deleteById(Integer id) {
        shopRoleRepository.deleteById(id);
    }

    @Override
    public void delete(ShopRole entity) {
        shopRoleRepository.delete(entity);
    }

    @Override
    public void deleteAll(List<ShopRole> entities) {
        shopRoleRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        shopRoleRepository.deleteAll();
    }

}
