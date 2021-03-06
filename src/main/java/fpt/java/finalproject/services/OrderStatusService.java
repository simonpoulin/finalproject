package fpt.java.finalproject.services;

import java.util.List;
import java.util.Optional;

import fpt.java.finalproject.models.OrderStatus;

public interface OrderStatusService {

    public OrderStatus save(OrderStatus entity);

    public List<OrderStatus> saveAll(List<OrderStatus> entities);

    public Optional<OrderStatus> findById(Integer id);

    public boolean existsById(Integer id);

    public List<OrderStatus> findAll();

    public List<OrderStatus> findAllById(List<Integer> ids);

    public long count();

    public void deleteById(Integer id);

    public void delete(OrderStatus entity);

    public void deleteAll(List<OrderStatus> entities);

    public void deleteAll();

}
