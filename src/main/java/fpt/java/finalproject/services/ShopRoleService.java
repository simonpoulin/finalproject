package fpt.java.finalproject.services;

public interface ShopRoleService {

    public  ShopRole  save(ShopRole entity) ;

    public List<ShopRole> saveAll(List<ShopRole> entities);

    public Optional<ShopRole> findById(Integer id);

    public boolean existsById(Integer id);

    public Iterable<ShopRole> findAll() ;

    public List<ShopRole> findAllById(List<Integer> ids);

    public long count() ;

    public void deleteById(Integer id) ;

    public void delete(ShopRole entity);

    public void deleteAll(List <ShopRole> entities) ;

    public void deleteAll() ;
    
}
