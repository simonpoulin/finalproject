package fpt.java.finalproject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import fpt.java.finalproject.models.CartDetail;

@Repository
public interface CartDetailRepository extends CrudRepository<CartDetail, Integer> {

}
