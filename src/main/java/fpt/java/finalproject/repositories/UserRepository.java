package fpt.java.finalproject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fpt.java.finalproject.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

}
