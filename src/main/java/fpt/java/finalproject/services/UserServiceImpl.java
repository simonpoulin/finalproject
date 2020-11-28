package fpt.java.finalproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import fpt.java.finalproject.models.User;
import fpt.java.finalproject.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> customFind(String clause) throws Exception {
        return userRepository.customFind(clause);
    }

    @Override
    public User findByUsername(String username) throws Exception {
        User u = new User();

        // Find employee
        Optional<User> opts = userRepository.findByUsername(username);

        // Set employee
        if (opts.isPresent()) {
            u = opts.get();
        } else {
            // Send error on fail
            throw new Exception("User not found");
        }

        return u;
    }

    @Override
    public User getAuthUser() {
        User u = new User();
        try {
            u = findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        } catch (Exception ex) {
            u = null;
        }
        return u;
    }

    @Override
    public void save(User entity) throws Exception {

        User u = userRepository.save(entity);

        // Send error on fail
        if (u == null) {
            throw new Exception("Cannot save");
        }
        
    }

    @Override
    public User findById(Integer id) throws Exception {

        User u = new User();

        // Find user
        Optional<User> opts = userRepository.findById(id);

        // Set user
        if (opts.isPresent()) {
            u = opts.get();
        } else {
            // Send error on fail
            throw new Exception("User not found");
        }

        return u;
    }

    @Override
    public List<User> findAll(){
        return (List<User>) userRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) throws Exception {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> saveAll(List<User> entities) {
        return (List<User>) userRepository.saveAll(entities);
    }

    @Override
    public boolean existsById(Integer id) {
        return userRepository.existsById(id);
    }

    @Override
    public List<User> findAllById(List<Integer> ids) {
        return (List<User>) userRepository.findAllById(ids);
    }

    @Override
    public long count() {
        return userRepository.count();
    }

    @Override
    public void delete(User entity) {
        userRepository.delete(entity);
    }

    @Override
    public void deleteAll(List<User> entities) {
        userRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }

}
