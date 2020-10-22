package fpt.java.finalproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fpt.java.finalproject.models.Order;
import fpt.java.finalproject.repositories.OrderReposirory;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderReposirory orderReposirory;
    @Override
    public  Order save(Order entity) {
        return orderReposirory.save(entity);
    }
    @Override
    public List<Order> saveAll(List<Order> entities) {
        return (List<Order>) orderReposirory.saveAll(entities);
    }
    @Override
    public Optional<Order> findById(Integer id) {
        return orderReposirory.findById(id);
    }
    @Override
    public boolean existsById(Integer id) {
        return orderReposirory.existsById(id);
    }
    @Override
    public List<Order> findAll() {
        return (List<Order>)orderReposirory.findAll();
    }
    @Override
    public List<Order> findAllById(List<Integer> ids) {
        return (List<Order>)  orderReposirory.findAllById(ids);
    }
    @Override
    public long count() {
        return orderReposirory.count();
    }
    @Override
    public void deleteById(Integer id) {
        orderReposirory.deleteById(id);
    }
    @Override
    public void delete(Order entity) {
        orderReposirory.delete(entity);
    }
    @Override
    public void deleteAll(List<Order> entities) {
        orderReposirory.deleteAll(entities);
    }
    @Override
    public void deleteAll() {
        orderReposirory.deleteAll();
    }

    
}
