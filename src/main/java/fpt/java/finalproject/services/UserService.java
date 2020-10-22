package fpt.java.finalproject.services;

import java.util.List;
import java.util.Optional;

import fpt.java.finalproject.models.User;

public interface UserService {

    public  User save(User entity) ;

    public List<User>  saveAll(List<User> entities) ;

    public Optional<User> findById(Integer id) ;

    public boolean existsById(Integer id) ;

    public List<User> findAll();

    public List<User> findAllById(List<Integer> ids) ;

    public long count() ;

    public void deleteById(Integer id);

    public void delete(User entity);

    public void deleteAll(List<User> entities) ;

    public void deleteAll() ;
    
}
