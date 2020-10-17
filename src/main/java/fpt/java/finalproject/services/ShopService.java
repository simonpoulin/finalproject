package fpt.java.finalproject.services;

public interface ShopService {

    public  Shop save(Shop entity) ;

    public List<Shop> saveAll(List<Shop> entities);

    public Optional<Shop> findById(Integer id) ;

    public boolean existsById(Integer id);

    public Iterable<Shop> findAll();

    public List<Shop> findAllById(List<Integer> ids);

    public long count() ;

    public void deleteById(Integer id);

    public void delete(Shop entity);

    public void deleteAll(List<Shop> entities);

    public void deleteAll() ;
    
}
