package fpt.java.finalproject.services;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fpt.java.finalproject.DTOS.ShopItemDto;
import fpt.java.finalproject.models.ShopItem;
import fpt.java.finalproject.repositories.ShopItemRepository;

@Service
public class ShopItemServiceImpl implements ShopItemService {

    @Autowired
    private ShopItemRepository shopItemRepository;

    @Autowired
    private Cloudinary cloudinary;

    @Override
    public List<ShopItem> customFind(Integer shopId, Integer productId)
            throws Exception {
        return shopItemRepository.customFind(0, 0, shopId, productId);
    }

    @Override
    public void save(ShopItemDto entity) throws Exception {
        ShopItem s = entity.convertToShopItem();
        try {
            if (!entity.getImage().getName().equals(entity.getImageName())) {
                Map<String, String> r = cloudinary.uploader().upload(entity.getImage().getBytes(),
                        ObjectUtils.asMap("public_id", UUID.randomUUID().toString()));
                s.setImage(r.get("public_id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Cannot save");
        }

        ShopItem shopItem = shopItemRepository.save(s);

        // Send error
        if (shopItem == null) {
            throw new Exception("Cannot save");
        }
    }

    @Override
    public List<ShopItem> saveAll(List<ShopItem> entities) {
        return (List<ShopItem>) shopItemRepository.saveAll(entities);
    }

    @Override
    public ShopItem findById(Integer id) throws Exception {
        ShopItem shopItem = new ShopItem();

        // Find by id
        Optional<ShopItem> optShopItem = shopItemRepository.findById(id);

        // Set ShopItem
        if (optShopItem.isPresent()) {
            shopItem = optShopItem.get();
        } else {
            // Send mess error
            throw new Exception("Cannot found");
        }
        return shopItem;
    }

    @Override
    public boolean existsById(Integer id) {
        return shopItemRepository.existsById(id);
    }

    @Override
    public List<ShopItem> findAll(){
        return (List<ShopItem>) shopItemRepository.findAll();
    }

    @Override
    public List<ShopItem> findAllById(List<Integer> ids) {
        return (List<ShopItem>) shopItemRepository.findAllById(ids);
    }

    @Override
    public long count() {
        return shopItemRepository.count();
    }

    @Override
    public void deleteById(Integer id) throws Exception {
        shopItemRepository.deleteById(id);
    }

    @Override
    public void delete(ShopItem entity) {
        shopItemRepository.delete(entity);
    }

    @Override
    public void deleteAll(List<ShopItem> entities) {
        shopItemRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        shopItemRepository.deleteAll();
    }
}
