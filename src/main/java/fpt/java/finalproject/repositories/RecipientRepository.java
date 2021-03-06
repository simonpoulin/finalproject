package fpt.java.finalproject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fpt.java.finalproject.models.Recipient;

@Repository
public interface RecipientRepository extends CrudRepository<Recipient, Integer> {

}
