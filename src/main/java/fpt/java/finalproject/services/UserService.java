package fpt.java.finalproject.services;

import java.util.List;

import fpt.java.finalproject.models.User;

public interface UserService {

    public void save(User entity) throws Exception;

    public List<User> findAll() throws Exception;

    public User findById(Integer id) throws Exception;

    public void deleteById(Integer id) throws Exception;

    public List<User> saveAll(List<User> entities);

    public boolean existsById(Integer id);

    public List<User> findAllById(List<Integer> ids);

    public long count();

    public void delete(User entity);

    public void deleteAll(List<User> entities);

    public void deleteAll();

}
