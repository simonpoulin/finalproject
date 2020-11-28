package fpt.java.finalproject.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fpt.java.finalproject.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    @Query(value    =   "SELECT * FROM users p ?1", nativeQuery = true)
    List<User> customFind(String clause);

    Optional<User> findByUsername(String username);
}
