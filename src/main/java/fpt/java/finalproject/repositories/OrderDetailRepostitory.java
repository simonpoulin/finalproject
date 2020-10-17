package fpt.java.finalproject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fpt.java.finalproject.models.OrderDetail;
@Repository
public interface OrderDetailRepostitory extends CrudRepository<OrderDetail, Integer> {
    
}
