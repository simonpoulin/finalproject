package fpt.java.finalproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fpt.java.finalproject.models.Cart;
import fpt.java.finalproject.repositories.CartRepository;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;
    @Override
    public Cart  save(Cart entity) {
        return cartRepository.save(entity);
    }
    @Override
    public List <Cart> saveAll(List<Cart> entities) {
        return (List<Cart>) cartRepository.saveAll(entities);
    }
    @Override
    public Optional<Cart> findById(Integer id) {
        return cartRepository.findById(id);
    }
    @Override
    public boolean existsById(Integer id) {
        return cartRepository.existsById(id);
    }
    @Override
    public Iterable<Cart> findAll() {
        return cartRepository.findAll();
    }
    @Override
    public List<Cart> findAllById(List<Integer> ids) {
        return (List<Cart>) cartRepository.findAllById(ids);
    }
    @Override
    public long count() {
        return cartRepository.count();
    }
    @Override
    public void deleteById(Integer id) {
        cartRepository.deleteById(id);
    }@Override
    public void delete(Cart entity) {
        cartRepository.delete(entity);
    }
    @Override
    public void deleteAll(List<Cart> entities) {
        cartRepository.deleteAll(entities);
    }
    @Override
    public void deleteAll() {
        cartRepository.deleteAll();
    }

    
}
