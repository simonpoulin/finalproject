package fpt.java.finalproject.services;

import java.util.List;
import java.util.Optional;

import fpt.java.finalproject.models.Cart;

public interface CartService {
    public Cart  save(Cart entity) ;

    public List<Cart> saveAll(List<Cart> entities);

    public Optional<Cart> findById(Integer id) ;

    public boolean existsById(Integer id) ;

    public List<Cart> findAll();

    public List<Cart> findAllById(List<Integer> ids);

    public long count() ;
    
    public void deleteById(Integer id);

    public void delete(Cart entity) ;

    public void deleteAll(List<Cart> entities) ;

    public void deleteAll();

    List<Cart> findByCartNameLikeOrderbyName(String cartName);
}
