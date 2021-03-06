package fpt.java.finalproject.services;

import java.util.List;
import java.util.Optional;

import fpt.java.finalproject.models.CartDetail;

public interface CartDetailSevice {

    public List<CartDetail> findByUserId(Integer userId) throws Exception;

    public CartDetail save(CartDetail entity);

    public List<CartDetail> saveAll(List<CartDetail> entities);

    public Optional<CartDetail> findById(Integer id);

    public boolean existsById(Integer id);

    public List<CartDetail> findAll();

    public List<CartDetail> findAllById(List<Integer> ids);

    public long count();

    public void deleteById(Integer id);

    public void delete(CartDetail entity);

    public void deleteAll(List<CartDetail> entities);

    public void deleteAll();

}
