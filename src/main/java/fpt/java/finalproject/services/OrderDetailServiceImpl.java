package fpt.java.finalproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fpt.java.finalproject.models.OrderDetail;
import fpt.java.finalproject.repositories.OrderDetailRepostitory;


@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailRepostitory oDetailRepostitory;
    @Override
    public  OrderDetail save(OrderDetail entity) {
        return oDetailRepostitory.save(entity);
    }
    @Override
    public List<OrderDetail>  saveAll(List<OrderDetail> entities) {
        return (List<OrderDetail>) oDetailRepostitory.saveAll(entities);
    }
    @Override
    public Optional<OrderDetail> findById(Integer id) {
        return oDetailRepostitory.findById(id);
    }
    @Override
    public boolean existsById(Integer id) {
        return oDetailRepostitory.existsById(id);
    }
    @Override
    public List<OrderDetail> findAll() {
        return (List<OrderDetail>)oDetailRepostitory.findAll();
    }
    @Override
    public List<OrderDetail> findAllById(List<Integer> ids) {
        return (List<OrderDetail>) oDetailRepostitory.findAllById(ids);
    }
    @Override
    public long count() {
        return oDetailRepostitory.count();
    }
    @Override
    public void deleteById(Integer id) {
        oDetailRepostitory.deleteById(id);
    }
    @Override
    public void delete(OrderDetail entity) {
        oDetailRepostitory.delete(entity);
    }
    @Override
    public void deleteAll(List<OrderDetail> entities) {
        oDetailRepostitory.deleteAll(entities);
    }
    @Override
    public void deleteAll() {
        oDetailRepostitory.deleteAll();
    }

    
}
