package fpt.java.finalproject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fpt.java.finalproject.models.Cart;

@Repository
public interface CartRepository extends CrudRepository<Cart, Integer> {

}
