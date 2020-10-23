package fpt.java.finalproject.services;

import java.util.List;
import java.util.Optional;

import fpt.java.finalproject.models.Recipient;

public interface RecipientService {

    public long count();

    public void delete(Recipient arg0);

    public void deleteAll();

    public void deleteAll(List<Recipient> arg0);

    public void deleteById(Integer arg0);

    public boolean existsById(Integer arg0);

    public List<Recipient> findAll();

    public List<Recipient> findAllById(List<Integer> arg0);

    public Optional<Recipient> findById(Integer arg0);

    public Recipient save(Recipient arg0);

    public List<Recipient> saveAll(List<Recipient> arg0);

}
