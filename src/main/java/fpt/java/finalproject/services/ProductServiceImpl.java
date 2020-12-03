package fpt.java.finalproject.services;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fpt.java.finalproject.DTOS.ProductDto;
import fpt.java.finalproject.models.Product;
import fpt.java.finalproject.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private Cloudinary cloudinary;

    @Override
    public List<Product> customFind(String name, Integer categoryId, Integer brandId) throws Exception {
        return productRepository.customFind(name, categoryId, brandId);
    }

    @Override
    public void save(ProductDto entity) throws Exception {

        Product p = entity.convertToProduct();
        try {
            if (!entity.getImage().getName().equals(entity.getImageName())) {
                Map<String, String> r = cloudinary.uploader().upload(entity.getImage().getBytes(),
                        ObjectUtils.asMap("public_id", UUID.randomUUID().toString()));
                p.setImage(r.get("public_id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Cannot save");
        }

        Product product = productRepository.save(p);

        // Send error
        if (product == null) {
            throw new Exception("Cannot save");
        }
    }

    @Override
    public List<Product> saveAll(List<Product> entities) {
        return (List<Product>) productRepository.saveAll(entities);
    }

    @Override
    public Product findById(Integer id) throws Exception {
        Product product = new Product();

        // find by id
        Optional<Product> optProduct = productRepository.findById(id);

        // Set Product
        if (optProduct.isPresent()) {
            product = optProduct.get();
        } else {
            // send mess error
            throw new Exception("Cannot found");
        }
        return product;
    }

    @Override
    public boolean existsById(Integer id) {
        return productRepository.existsById(id);
    }

    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public List<Product> findAllById(List<Integer> ids) {
        return (List<Product>) productRepository.findAllById(ids);
    }

    @Override
    public long count() {
        return productRepository.count();
    }

    @Override
    public void deleteById(Integer id) throws Exception {
        productRepository.deleteById(id);
    }

    @Override
    public void delete(Product entity) {
        productRepository.delete(entity);
    }

    @Override
    public void deleteAll(List<Product> entities) {
        productRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        productRepository.deleteAll();
    }

}
