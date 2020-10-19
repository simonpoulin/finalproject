package fpt.java.finalproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fpt.java.finalproject.models.ShopItemImage;
import fpt.java.finalproject.repositories.ShopItemImageRepository;

@Service
public class ShopItemImageServiceIpml implements ShopItemImageService {
    @Autowired
    private ShopItemImageRepository shopItemImageRepository;

    @Override
    public ShopItemImage  save(ShopItemImage entity) {
        return shopItemImageRepository.save(entity);
    }
    @Override
    public List<ShopItemImage>  saveAll(List<ShopItemImage> entities) {
        return (List<ShopItemImage>) shopItemImageRepository.saveAll(entities);
    }
    @Override
    public Optional<ShopItemImage> findById(Integer id) {
        return shopItemImageRepository.findById(id);
    }
    @Override
    public boolean existsById(Integer id) {
        return shopItemImageRepository.existsById(id);
    }
    @Override
    public Iterable<ShopItemImage> findAll() {
        return shopItemImageRepository.findAll();
    }
    @Override
    public List<ShopItemImage> findAllById(List<Integer> ids) {
        return (List<ShopItemImage>) shopItemImageRepository.findAllById(ids);
    }
    @Override
    public long count() {
        return shopItemImageRepository.count();
    }
    @Override
    public void deleteById(Integer id) {
        shopItemImageRepository.deleteById(id);
    }
    @Override
    public void delete(ShopItemImage entity) {
        shopItemImageRepository.delete(entity);
    }
    @Override
    public void deleteAll(List<ShopItemImage> entities) {
        shopItemImageRepository.deleteAll(entities);
    }
    @Override
    public void deleteAll() {
        shopItemImageRepository.deleteAll();
    }

    
}
