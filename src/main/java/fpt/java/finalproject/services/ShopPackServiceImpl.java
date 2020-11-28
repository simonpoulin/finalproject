package fpt.java.finalproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fpt.java.finalproject.models.ShopPack;
import fpt.java.finalproject.repositories.ShopPackRepository;

@Service
public class ShopPackServiceImpl implements ShopPackService {

    @Autowired
    private ShopPackRepository shopPackRepository;

    @Override
    public List<ShopPack> customFind(String clause) throws Exception {
        return shopPackRepository.customFind(clause);
    }

    @Override
    public ShopPack save(ShopPack entity) {
        return shopPackRepository.save(entity);
    }

    @Override
    public List<ShopPack> saveAll(List<ShopPack> entities) {
        return (List<ShopPack>) shopPackRepository.saveAll(entities);
    }

    @Override
    public ShopPack findById(Integer id) {
        ShopPack shopPack = new ShopPack();

        // find by id
        Optional<ShopPack> optShopPack = shopPackRepository.findById(id);

        // Set shopPack
        if (optShopPack.isPresent()) {
            shopPack = optShopPack.get();
        }
        
        return shopPack;
    }

    @Override
    public boolean existsById(Integer id) {
        return shopPackRepository.existsById(id);
    }

    @Override
    public List<ShopPack> findAll() {
        return (List<ShopPack>) shopPackRepository.findAll();
    }

    @Override
    public List<ShopPack> findAllById(List<Integer> ids) {
        return (List<ShopPack>) shopPackRepository.findAllById(ids);
    }

    @Override
    public long count() {
        return shopPackRepository.count();
    }

    @Override
    public void deleteById(Integer id) {
        shopPackRepository.deleteById(id);
    }

    @Override
    public void delete(ShopPack entity) {
        shopPackRepository.delete(entity);
    }

    @Override
    public void deleteAll(List<ShopPack> entities) {
        shopPackRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        shopPackRepository.deleteAll();
    }

}
