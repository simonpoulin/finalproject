package fpt.java.finalproject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fpt.java.finalproject.models.OrderStatus;
@Repository
public interface OrderStatusRepository extends CrudRepository<OrderStatus , Integer > {
    
}
