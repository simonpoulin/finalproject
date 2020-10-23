package fpt.java.finalproject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fpt.java.finalproject.models.Order;

@Repository
public interface OrderReposirory extends CrudRepository<Order, Integer> {

}
