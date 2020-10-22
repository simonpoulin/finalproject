package fpt.java.finalproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fpt.java.finalproject.models.Recipient;
import fpt.java.finalproject.repositories.RecipientRepository;

@Service
public class RecipientServiceImpl implements RecipientService {
    @Autowired
    private RecipientRepository recipientRepository;

    public long count() {
        return recipientRepository.count();
    }

    public void delete(Recipient arg0) {
        recipientRepository.delete(arg0);
    }

    public void deleteAll() {
        recipientRepository.deleteAll();
    }

    public void deleteAll(List<Recipient> arg0) {
        recipientRepository.deleteAll(arg0);
    }

    public void deleteById(Integer arg0) {
        recipientRepository.deleteById(arg0);
    }

    public boolean existsById(Integer arg0) {
        return recipientRepository.existsById(arg0);
    }

    public List<Recipient> findAll() {
        return (List<Recipient>)recipientRepository.findAll();
    }

    public List<Recipient> findAllById(List<Integer> arg0) {
        return (List<Recipient>) recipientRepository.findAllById(arg0);
    }

    public Optional<Recipient> findById(Integer arg0) {
        return recipientRepository.findById(arg0);
    }

    public Recipient save(Recipient arg0) {
        return recipientRepository.save(arg0);
    }

    public List<Recipient> saveAll(List<Recipient> arg0) {
        return (List<Recipient>) recipientRepository.saveAll(arg0);
    }
    
    
    

}
