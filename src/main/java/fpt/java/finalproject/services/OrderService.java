package fpt.java.finalproject.services;

import java.util.List;
import java.util.Optional;

import fpt.java.finalproject.models.Order;

public interface OrderService {

    public Order save(Order entity);

    public List<Order> saveAll(List<Order> entities);

    public Optional<Order> findById(Integer id);

    public boolean existsById(Integer id);

    public List<Order> findAll();

    public List<Order> findAllById(List<Integer> ids);

    public long count();

    public void deleteById(Integer id);

    public void delete(Order entity);

    public void deleteAll(List<Order> entities);

    public void deleteAll();

}
