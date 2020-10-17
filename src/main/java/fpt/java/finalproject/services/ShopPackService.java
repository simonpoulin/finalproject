package fpt.java.finalproject.services;

public interface ShopPackService {
  
    public  ShopPack  save(ShopPack entity);

    public  List<ShopPack>  saveAll(List<ShopPack> entities);

    public Optional<ShopPack> findById(Integer id) ;

    public boolean existsById(Integer id) ;

    public Iterable<ShopPack> findAll() ;

    public List<ShopPack> findAllById(List<Integer> ids);

    public long count() ;

    public void deleteById(Integer id);

    public void delete(ShopPack entity) ;

    public void deleteAll(List<ShopPack> entities);

    public void deleteAll();
}
