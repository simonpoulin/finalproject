package fpt.java.finalproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fpt.java.finalproject.models.Shop;
import fpt.java.finalproject.repositories.ShopRepository;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopRepository shopRepository;

    @Override
    public List<Shop> customFind(String name) throws Exception {
        return shopRepository.customFind(name);
    }

    @Override
    public void save(Shop entity) throws Exception {
       Shop shop = shopRepository.save(entity);

       // Send error
        if(shop == null){
            throw new Exception("Cannot save");
        }
    }

    @Override
    public List<Shop> saveAll(List<Shop> entities) {
        return (List<Shop>) shopRepository.saveAll(entities);
    }

    @Override
    public Shop findById(Integer id) throws Exception {
        Shop shop = new Shop();

        // find by id 
        Optional<Shop> optShop = shopRepository.findById(id);

        // Set shop
        if(optShop.isPresent()){
            shop = optShop.get();
        }else{
            // Send mess error
            throw new Exception("Cannot save");
        }
        return shop;
    }

    @Override
    public boolean existsById(Integer id) {
        return shopRepository.existsById(id);
    }

    @Override
    public List<Shop> findAll() {
        return (List<Shop>) shopRepository.findAll();
    }

    @Override
    public List<Shop> findAllById(List<Integer> ids) {
        return (List<Shop>) shopRepository.findAllById(ids);
    }

    @Override
    public long count() {
        return shopRepository.count();
    }

    @Override
    public void deleteById(Integer id) throws Exception {
        shopRepository.deleteById(id);
    }

    @Override
    public void delete(Shop entity) {
        shopRepository.delete(entity);
    }

    @Override
    public void deleteAll(List<Shop> entities) {
        shopRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        shopRepository.deleteAll();
    }
}
