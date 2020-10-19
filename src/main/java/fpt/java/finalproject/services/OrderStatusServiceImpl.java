package fpt.java.finalproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fpt.java.finalproject.models.OrderStatus;
import fpt.java.finalproject.repositories.OrderStatusRepository;


@Service
public class OrderStatusServiceImpl implements OrderStatusService {

    @Autowired
    private OrderStatusRepository orderStatusRepository;
    @Override
    public OrderStatus save(OrderStatus entity) {
        return orderStatusRepository.save(entity);
    }
    @Override
    public List<OrderStatus> saveAll(List<OrderStatus> entities) {
        return  (List<OrderStatus>) orderStatusRepository.saveAll(entities);
    }
    @Override
    public Optional<OrderStatus> findById(Integer id) {
        return orderStatusRepository.findById(id);
    }
    @Override
    public boolean existsById(Integer id) {
        return orderStatusRepository.existsById(id);
    }
    @Override
    public Iterable<OrderStatus> findAll() {
        return orderStatusRepository.findAll();
    }
    @Override
    public List<OrderStatus> findAllById(List<Integer> ids) {
        return (List<OrderStatus>) orderStatusRepository.findAllById(ids);
    }
    @Override
    public long count() {
        return orderStatusRepository.count();
    }
    @Override
    public void deleteById(Integer id) {
        orderStatusRepository.deleteById(id);
    }
    @Override
    public void delete(OrderStatus entity) {
        orderStatusRepository.delete(entity);
    }
    @Override
    public void deleteAll(List<OrderStatus> entities) {
        orderStatusRepository.deleteAll(entities);
    }
    @Override
    public void deleteAll() {
        orderStatusRepository.deleteAll();
    }

    

}
