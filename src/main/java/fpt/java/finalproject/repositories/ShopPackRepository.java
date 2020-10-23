package fpt.java.finalproject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fpt.java.finalproject.models.ShopPack;

@Repository
public interface ShopPackRepository extends CrudRepository<ShopPack, Integer> {

}
