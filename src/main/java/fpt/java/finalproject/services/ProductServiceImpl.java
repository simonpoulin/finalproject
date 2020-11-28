package fpt.java.finalproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fpt.java.finalproject.models.Product;
import fpt.java.finalproject.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> customFind(String clause) {
        return productRepository.customFind(clause);
    }
    
    @Override
    public void save(Product entity)  throws Exception{
       Product product = productRepository.save(entity);

       // Send error
       if(product == null){
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
       if(optProduct.isPresent()){
           product = optProduct.get();
       }else{
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
    public void deleteById(Integer id) throws Exception{
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
