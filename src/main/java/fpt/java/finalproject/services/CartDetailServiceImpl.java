package fpt.java.finalproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fpt.java.finalproject.models.CartDetail;
import fpt.java.finalproject.repositories.CartDetailRepository;
@Service
public class CartDetailServiceImpl implements CartDetailSevice {

    @Autowired
    private CartDetailRepository cartDetailRepository;
    @Override
    public CartDetail  save(CartDetail entity) {
        return cartDetailRepository.save(entity);
    }
    @Override
    public List<CartDetail> saveAll(List<CartDetail> entities) {
        return (List<CartDetail>) cartDetailRepository.saveAll(entities);
    }
    @Override
    public Optional<CartDetail> findById(Integer id) {
        return cartDetailRepository.findById(id);
    }
    @Override
    public boolean existsById(Integer id) {
        return cartDetailRepository.existsById(id);
    }
    @Override
    public Iterable<CartDetail> findAll() {
        return cartDetailRepository.findAll();
    }
    @Override
    public List<CartDetail> findAllById(List<Integer> ids) {
        return (List <CartDetail>) cartDetailRepository.findAllById(ids);
    }
    @Override
    public long count() {
        return cartDetailRepository.count();
    }
    @Override
    public void deleteById(Integer id) {
        cartDetailRepository.deleteById(id);
    }
    @Override
    public void delete(CartDetail entity) {
        cartDetailRepository.delete(entity);
    }
    @Override
    public void deleteAll(List<CartDetail> entities) {
        cartDetailRepository.deleteAll(entities);
    }
    @Override
    public void deleteAll() {
        cartDetailRepository.deleteAll();
    }

    
}
