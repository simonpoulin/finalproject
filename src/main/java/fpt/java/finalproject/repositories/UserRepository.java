package fpt.java.finalproject.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fpt.java.finalproject.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    @Query(value = "exec search_user :name", nativeQuery = true)
    List<User> customFind(@Param("name") String name);

    Optional<User> findByUsername(String username);
}
